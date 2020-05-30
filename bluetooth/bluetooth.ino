#include <SoftwareSerial.h>

#define rxd 8
#define txd 7
SoftwareSerial bluetooth(rxd,txd);
void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  bluetooth.begin(9600);

}

void loop() {
  // put your main code here, to run repeatedly:
  if(bluetooth.available()){
    Serial.write(bluetooth.read());
  }
  if(Serial.available()){
    //bluetooth.println("10 20 30");
    bluetooth.write(Serial.read());
  }

}
