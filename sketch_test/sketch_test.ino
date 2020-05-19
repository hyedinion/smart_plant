#include <DallasTemperature.h>
#include <OneWire.h>

#define HumiP A0
#define LuxP A1
#define TemP 2

#define LED 12   //on off 
#define LED_state 11   //빛 세기

#define PumP 8  //on off
#define PumP_speed 9 //모터 세기
#define Loop 

OneWire dt(TemP);
DallasTemperature sensors(&dt);

unsigned long watertime = 0;
bool wateron = false;
byte settingHumi = 20;
byte settingLux = 40;
float preTemp = 0;
char TempValue[] = {-3,-2,-2,-1,-1,0,0,0,1,1,2};
char Tempset=6;
byte settingLED = 20;
unsigned long timer=0;
char loopset=0;
unsigned long Looptime[] = {10000,15000,25000,40000,60000,120000,300000,600000};

void setup() {
  Serial.begin(9600);
  
  pinMode(HumiP,INPUT);
  pinMode(LuxP,INPUT); 
  pinMode(TemP,INPUT); 
  
  pinMode(LED,INPUT); 
  pinMode(LED_state,INPUT); 
  
  pinMode(PumP,INPUT); 
  pinMode(PumP_speed,INPUT); 

  //초기 온도 설정
  preTemp = getTemperature();

  //LED 켜기
  analogWrite(LED_state,20);
  digitalWrite(LED,HIGH);
}

void loop() {
  if ( timer + Looptime[loopset] > millis() ) {
    if ( settingHumi <= getHumidity() && wateron == false ) {
      WaterPumpOn(settingHumi-getHumidity());
      settingLoop(-1);
    }
    else if (settingHumi > getHumidity()) settingLoop(1);
    
    if ( settingLux <= getLux()-3 || settingLux >= getLux()+3 ) {
      Turn_LED_Light(settingLED+((settingLux - getLux())*5/2));
      settingLoop(-1);
    }
    else settingLoop(1);

    settingTempV();
  }
  
  if (wateron&&watertime < millis()) {
    WaterPumpOff();
    settingLoop(-1);
  }
}



byte getHumidity()  //토양수분 0~100까지 출력(일반 물70, 소금물85, 공기 0)
{
   return (100-map(analogRead(HumiP),0,1023,0,100));
}

float getTemperature() //소수점 2자리까지 실제 온도 출력
{
   sensors.requestTemperatures();
   return sensors.getTempCByIndex(0);
}

byte getLux() //조도량 출력(0~100)
{
   return (100-map(analogRead(LuxP),0,1023,0,100));
}

void WaterPumpOn(byte timenum) // time s 만큼 펌프 가동
{
  analogWrite(PumP_speed,255); //펌프세기 100(0~100);
  digitalWrite(PumP,HIGH);
  watertime = millis() + timenum*1000;
  wateron = true;
}

void WaterPumpOff() // time = 0될경우 펌프 종료
{
  wateron = false;
  digitalWrite(PumP,LOW);
}

void Turn_LED_Light(byte a) //Led 밝기 조절(0~255);
{
  analogWrite(LED_state,a);
  settingLED = a;
}

void settingLoop(char a)
{
  loopset = min(7,max(0,loopset += a));
}

void settingTempset(char a)
{
  Tempset = min(10,max(0,Tempset += a));
}

void settingTempV()
{
  if (getTemperature() - preTemp < -8 || getTemperature() - preTemp > 8) settingTempset(-3);
  else if (getTemperature() - preTemp < -6 || getTemperature() - preTemp > 6) settingTempset(-2);
  else if (getTemperature() - preTemp < -3 || getTemperature() - preTemp > 3) settingTempset(-1);
  else if (getTemperature() - preTemp < -1 || getTemperature() - preTemp > 1) settingTempset(0);
  else settingTempset(1);

  preTemp = getTemperature();
}
