Parking Lot Application

Assumptions :
1. The size of parking lot can be increased any time
2. The parking lot is same for car and bike
3. The hours can be in decimals like 2.5 hrs
4. The registration number cannot be same for two vehicles

Tools Used :
1. Java 8
2. Maven
3. JUnit 5

Commands for running :
Compile and running the test cases -> mvn clean install
To run the application -> java -jar /target/parking_lot-1.0-SNAPSHOT.jar
 
 
Input file with filename "parking_lot_file_inputs.txt" having commands :
create_parking_lot 6
park KA-01-HH-1234
park KA-01-HH-9999
park KA-01-BB-0001
park KA-01-HH-7777
park KA-01-HH-2701
park KA-01-HH-3141
leave KA-01-HH-3141 4
status
park KA-01-P-333
park DL-12-AA-9999
leave KA-01-HH-1234 4
leave KA-01-BB-0001 6
leave DL-12-AA-9999 2
park KA-09-HH-0987
park CA-09-IO-1111
park KA-09-HH-0123
status

Output in console :
Enter input file path and name:D:\RISESMART\Workspace\parking_lot\bin\parking_lot_file_inputs.txt
You entered: D:\RISESMART\Workspace\parking_lot\bin\parking_lot_file_inputs.txt
Dec 11, 2020 5:35:24 PM com.gofin.service.ParkingLotService readCommandFile
INFO: Reading input file for commands
Created parking lot with 6 slots
Allocated Slot Number : 1
Allocated Slot Number : 2
Allocated Slot Number : 3
Allocated Slot Number : 4
Allocated Slot Number : 5
Allocated Slot Number : 6
Registration number KA-01-HH-3141 with Slot Number 6 is free with Charge 30
Slot No. 	 Registration No.
1 	 KA-01-HH-1234
2 	 KA-01-HH-9999
3 	 KA-01-BB-0001
4 	 KA-01-HH-7777
5 	 KA-01-HH-2701
Allocated Slot Number : 6
Sorry, parking lot is full
Registration number KA-01-HH-1234 with Slot Number 1 is free with Charge 30
Registration number KA-01-BB-0001 with Slot Number 3 is free with Charge 50
Registration number DL-12-AA-9999 not found
Allocated Slot Number : 1
Allocated Slot Number : 3
Sorry, parking lot is full
Slot No. 	 Registration No.
1 	 KA-09-HH-0987
2 	 KA-01-HH-9999
3 	 CA-09-IO-1111
4 	 KA-01-HH-7777
5 	 KA-01-HH-2701
6 	 KA-01-P-333
