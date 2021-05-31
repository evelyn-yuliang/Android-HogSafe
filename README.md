# Android-HogSafe

#Goal
During the pandemic, the revnue of dine-in restaurants has dropped significantly. This application create a safe dining environment without close interaction with guests to order and make a reservation on the app.

#Scope
This application is designed to provide an integrated platform for guests to choose or search restaurant, reserve and order in a click.

#Features
*contactless ordering
Guests can use search bar to find the preferred restaurant in the city.
Guests can view the menu.
Guests can make an order without close contact with the staff.

*Reservation
Guests can start a tabke and make a new order.
Guests can join an existing table and make an order.

#Restaurant reservations outline / Quick review:
Decision : Dine-in or take-out
Getting location and showing nearby restaurants
If : Takeout (do not show book/join a table option)
Else : Show book/join a table option
If the user goes with the view menu, proceed with menu view and cart adding workflow. After the cart has been added, start booking a table/join a table activity.
If the user goes for booking a table first, take the booking and at the end of booking, redirect the user to menu view and proceed with cart adding workflow.
After clicking on join a table, only one screen is shown that will allow the user to enter the code to the table. After entering the correct code, proceed with the view menu and cart adding workflow.


