# CircoBill
Bill formatter - formats service data into a printable bill that can be sent to customers. Collects data and adds to a database
Circo Inc copyright 2015


Instructions: Circo Billing  V 1.2
The Basics
Throughout the instructions the term ‘field’ will be used to denote areas where text can be placed (e.g. ‘CustomerName’ in the upper right corner below the logo would be a field). The term ‘label’ will be used to describe the areas which serve as a descriptive label to the fields (e.g. ‘Date of Service:’ and ‘Billed Hours:’ are labels).

This programis designed to allow users to enter data one of two ways:
Method 1. Calculate the bill by hand entering information into the fields as needed
Method 2. Enter time into the ‘hours’ and ’minutes’ fields , the materials used (with price information) into the ‘Materials Used’ field, and any miscellaneous charges into the ‘Miscellaneous’ field.

Any field or label can be modified so  as to provide flexibility in creating bills as demonstrated in the images below:

  





Fields and labels can be edited simply by clicking the mouse on the desired text.

Instructions:
Method  1. 
a.	Enter information into all necessary fields, be sure to include the phone number to save the customer record to the database.
b.	Click the ‘Print’ button located at the bottom of the page.

Method  2.
1.	Fill-in customer information the fields
a.	Upper-left  half – customer information
The upper left half of the screen contains several fields including a spot for the customer name, mailing address, city, zip, and property address:

   
Simply fill out the name, mailing address, city, state, and zip. If the property the work was done at is different from the mailing address fill out the ‘PropertyAddress’  field. If the property Address and mailing address are the same just leave the property address field alone and it will ‘disappear’ when you print the bill. Notice, when you click on a field it is highlighted, there is no need to hit delete or backspace, just type in the name, address, city, etc. and it will be automatically deleted. 
 Below is an example:
 
Notice the ‘PropertyAddress’  remains unchanged since this hypothetical customer lives at the address where the work was performed and the mailing and property address are the same (this will be the case with most bills).  As stated above this will not appear on the bill when it is printed. Also note the format used for the city, state, and zipcode. It is a standard form and will allow the underlying database (which catalogues all bills and customers) to be able to store the information.
b.	Upper-right half – customer phone number, bill total, invoice #, etc.
The upper right half contains Circo’s address and several fields.  Each of the fields will be detailed below:  
At the top is a spot for your customer phone numbers -both a primary and secondary if necessary (which will not be displayed when you print the bill). Customer’s will added to the underlying database only if a phone number is provided in the ‘Customer Phone Number’ field (the alternate customer phone is optional).  The format is flexible but it is recommended that you keep it consistent (some suggested formats might be (303)555-5555 or 303555555 or 555-555-5555).

 

Next is an ’Invoice #’ field. You can fill this in or just leave it blank and an invoice number will be generated automatically (or like all labels and fields it can be erased so it is blank). 

Below the ’Invoice #’ field is’ Amount Due’ which is not necessary to fill in and will automatically calculated. 

Finally there is a ‘Bill Date’ field. The date will automatically be inserted when you click on the ‘Calculate’ button.

c.	Center Section – Bill Summary 
The Bill Summary contains a number of important fields which must be filled out in order to automatically calculate the bill. These include:
‘Date of Service’ – Field to record the date on which the service was performed. Delete this field if it is not applicable.
‘hours’ – This field records billable hours spent by a service technician on a particular call (at a rate of $90.00/hour).
‘minutes’ – Field to record billable minutes spent by a service technician on a call (at a rate of $1.50/minute).
‘Miscellaneous’ – Field to record non-standard or varying charges that might occur over the course of a service call.  The label can be edited to whatever description is appropriate or deleted as needed. Do not include a $ when using the miscellaneous field.

 



All other fields besides the ones detailed above will be filled in automatically and it is unnecessary to enter any values into them.
d.	Lower portion – service report and materials fields
The ‘Service Report’ field is used to describe work performed. The label, like the majority of labels, can be changed to a more fitting description if necessary.
The ’Materials used’ field is used to record all materials used on the service call. The information must be entered in the following format for the automatic calculation to work correctly:
		[Quantity]  [Product-Name] - $ [Unit Price]
Ex.   2 1804 Rainbird pop-up heads $3.45

 
	 

If the ‘Materials Used’ field is not large enough to accommodate all materials entered they  will have to be printed onto a separate page from the rest of the bill. If a scroll bar appears on the right side of the field this indicates that the ‘Materials Used’ field is not long enough for the amount of materials listed:
 



e.	The bottom – the buttons
There are four buttons located at the bottom of the screen: ‘Print’, ‘Calculate Bill’, ‘Print Materials Only’, and ‘Reset Bill’.
The ‘Print’ button -- When the ‘Print’ button is pressed all fields that are not filled it will be hidden and the document will be printed.  
 	
The ‘Calculate’ button – When this button is used the totals will be calculated and displayed in the bill.	
 									
The ‘Print Materials Only’ button – When this button is pressed the materials will be printed on a separate page. Only necessary to use when the materials will not fit in the area provided as determined by a scroll bar appearing on the right hand side of the field while entering materials.
 	
The ‘Reset Bill’ button – This button will clear all fields. Used primarily when a bill has been finished and a new one needs to be created.			
 					

