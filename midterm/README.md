# Frank Ziegler OOD Midterm
# Design Decisions
## Overall Approach

The NJMVC runs on transactions. The domain object in an NJMVC simulation is a "transaction." This application focuses on the registration of a vehicle, sure, but a registration is only a part of a transaction. 

Transactions are complex objects with an associated:
- Registration
- Customer
- Vehicle
- Type

The type of transaction is important because the logic of the system really depends on it and is the reason for a lot of my design decisions. When you're registering a vehicle for the first time, a registration and a license plate needs to be generated. If you're transferring the registration to another customer, a registration already exists and a new customer needs to be entered. Renewing a registration also requires an existing one.

I will also note that these are *registration-based* transactions. In an extension of this system, to handle licensing and titling, we'd have different *kinds* of transactions like `LicensingTransaction` or `TitlingTransaction`. 

So the objects stored in the "database" (which is just a text file, by the way) are `RTransaction` objects. They include the customer, the vehicle, the license plate, etc. 

## `FeeRule` and `FeeCalculator`

In the NJMVC, there are a million fees. In a simulator, it's important to make sure that the calculation is done automatically based on the context of the transaction object (meaning, the vehicle, the transaction type). 

So there is a `FeeCalculator` that has a list of `FeeRule`s. And a given implementing `FeeRule` will return true if it applies to the transaction, and subsequently calculate the associated fee (dependent on NJMVC documentation). The `FeeCalculator` cycles through all of the registration-related fees and if they apply, they add to the overall total. 

## `ProcessorFactory` and `TransactionProcessor`s

The first design pattern I used was the factory pattern. Different processing is needed for different kinds of transactions. Again, there are multiple kinds of transactions: INITIAL, TRANSFER, RENEWAL, etc. 

Thus we have a `TransactionProcessor` interface with implementing classes like `InitialRegistrationProcessor`, `RenewalRegistrationProcessor`, etc. So we have a processing factory `ProcessorFactory` that returns the appropriate `TransactionProcessor` based upon the transaction type it is passed. Each transaction processor appropriately updates the transaction based upon the logic needed by the NJMVC. 

## `TransactionBuilder`

I ran into an issue with `TransactionProcessor` because different processors required different parameters. Transfers required a new customer/owner. Initials required custom/special license plates. 

Building a transaction is complex because there are different *contexts* for transactions based upon their type. Renewals required an existing registration, initials did not. Initials required special plates, renewals did not. Transfers required two customers, initials did not. This means the transaction constructor telescopes, which is a perfect setting for a builder pattern implementation for transactions. So all transactions are built with a `TransactionBuilder`.

## Singleton

The database I chose was a text file for simplicity. `RTransactionRepo` handles the database writing through the Bill Pugh singleton pattern and has a single function: `save`, that writes the textual representation of a given transaction to the database with a Java `FileWriter`. 

## IO

`Main` is the interface the client uses to make new transactions, but almost all of the IO code is delegated to the `InputCollector` because of how messy it is. All objects in the application have a `collect` method, i.e. `collectCustomer` or `collectVehicle`. 

## Misc.

The project is structured in such a way that functionality is separated. Any domain objects are a part of the model package. Services like `TransactionService` and fee calculations/rules are a part of the service package. Data persistence is a part of the repository package. 

The rest is basic inheritance and polymorphism. 

# Output

```
frankzigs@mbp midterm % java -cp out Main
+--------------------------------+
|                                |
|      welcome to the njmvc      |
|   online registration system   |
|          ood midterm           |
|         frank ziegler          |
|                                |
+--------------------------------+

Main Menu
1. New transaction
0. Quit
1
1. New registration
2. Renew registration
3. Transfer registration
Choose transaction type: 2
RENEWAL
1. Individual
2. Business
Choose customer type: 1
1
Name: frank ziegler
frank ziegler
Street address: 34 yarmouth way
34 yarmouth way
City: gibbsboro
gibbsboro
Abbreviated state (NJ, PA, etc.): nj
NJ
Zip: 08026
08026
County: camden
camden
Your name as it appears on your license: frank w ziegler iii
frank w ziegler iii
License number: z4269abc
z4269abc
License class (A-E): c
C
Date of birth (MM/DD/YYYY): 10/09/1998
1998-10-09
Issued date (MM/DD/YYYY): 10/09/2023
2023-10-09
Expiry date (MM/DD/YYYY): 10/09/2027
2027-10-09
SSN: 152xxxxxx
152xxxxxx
1. Car
2. Truck
3. Motorcycle
4. Boat
5. Commercial
Choose vehicle type: 1
1
Make: chevrolet
chevrolet
Model: impala
impala
Year: 2016
chevrolet
Color: silver
silver
Odometer reading: 164000
164000
DIESEL, ETHANOL, ELECTRIC, GASOLINE, HYDROGEN, HYBRID, BIODIESEL, NATURAL_GAS, PREMIUM_UNLEADED
Choose fuel type: gasoline
GASOLINE
License plate number: v42rrs
v42rrs
GVWR: 10000
10000.0
VIN: idkidkidk123456
idkidkidk123456
Registration ID: 1
1
Issued date (MM/DD/YYYY): 10/09/2024
Expiry date (MM/DD/YYYY): 10/09/2025
Your fee is $137.0. To pay, type and enter that number or more.
Pay here: 137.
Exact change. I like it.
Here is your new registration:
Registration ID: 1
Owner: frank ziegler
Vehicle: 2016 chevrolet impala
Issued: 2025-10-24
Expires: 2026-10-24
License plate: v42rrs

Main Menu
1. New transaction
0. Quit
0
Goodbye.
```