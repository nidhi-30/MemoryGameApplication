# MemoryGameApplication

The development is done Kotlin by using one Activity, Fragments, and Navigation Component. To make user interface interactive, animation with help of gradients and attractive font-family for the text has been used in application.

The application starts from the lobby page, where user can select the options according to the size of game they want to play. After selection the size option, user will be navigated to the next view where they can play game. singleton class has been created to pass the detail of selected size and show the cards in next view. To display cards according to the different grids, used RecyclerView with layout manager as GridLayout.

For the list of cards, array of all the images has been taken first and according to size of the selected game, random images has been selected and stored in another array by duplicating them. Also, to check whether the card is faced or whether card is matched, created a class (MemoryCard) and used the list of created class (MemoryCard). The list of MemoryCard has been used to update the cards view according the value.

When user enters the game, none of the cards show the image. When user clicks on card, user can see the selected card’s face and then select another card. If both selected cards do not match, both the cards will be flipped back when user will select third card. Also, if both selected cards are same, then both the cards will be faded as shown in Fig. 6, and user can not select them in
future. If user will select the matched card or card which shows the image, user will face the dialog which can be seen in Fig. 8. User can dismiss the dialog and can continue the game. During the game, user can click on the back button on top to leave the game. The game will continue until all cards are matched and then user can click on back button to go to the lobby.
