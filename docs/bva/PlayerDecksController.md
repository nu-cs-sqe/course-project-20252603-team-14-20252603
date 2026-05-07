### Method under test: `onNameTag(int playerIndex)`
- **TC1: game not started, player index INT_MIN** ( :x: )
    - **Name of the test**: 
    - **State of the system**: isGameOngoing = false, playerIndex = INT_MIN
    - **Expected output**: called handleChangeCurrentPlayer(playerIndex)

- **TC2: game not started, player index INT_MAX** ( :x: )
    - **Name of the test**: 
    - **State of the system**: isGameOngoing = false, playerIndex = INT_MAX
    - **Expected output**: called handleChangeCurrentPlayer(playerIndex)

- **TC3: game not started, player index 0** ( :x: )
    - **Name of the test**:
    - **State of the system**: isGameOngoing = false, playerIndex = 0
    - **Expected output**: called handleChangeCurrentPlayer(playerIndex)

- **TC4: game not started, player index 1** ( :x: )
    - **Name of the test**:
    - **State of the system**: isGameOngoing = false, playerIndex = 1
    - **Expected output**: called handleChangeCurrentPlayer(playerIndex)

- **TC5: game not started, player index -1** ( :x: )
    - **Name of the test**:
    - **State of the system**: isGameOngoing = false, playerIndex = -1
    - **Expected output**: called handleChangeCurrentPlayer(playerIndex)

- **TC6: game started, player index INT_MIN** ( :x: )
    - **Name of the test**:
    - **State of the system**: isGameOngoing = true, playerIndex = INT_MIN
    - **Expected output**: called handleChangeCurrentPlayer(playerIndex)

- **TC7: game started, player index INT_MAX** ( :x: )
    - **Name of the test**:
    - **State of the system**: isGameOngoing = true, playerIndex = INT_MAX
    - **Expected output**: called handleChangeCurrentPlayer(playerIndex)

- **TC8: game started, player index 0** ( :x: )
    - **Name of the test**:
    - **State of the system**: isGameOngoing = true, playerIndex = 0
    - **Expected output**: called handleChangeCurrentPlayer(playerIndex)

- **TC9: game started, player index 1** ( :x: )
    - **Name of the test**:
    - **State of the system**: isGameOngoing = true, playerIndex = 1
    - **Expected output**: called handleChangeCurrentPlayer(playerIndex)

- **TC10: game started, player index -1** ( :x: )
    - **Name of the test**:
    - **State of the system**: isGameOngoing = true, playerIndex = -1
    - **Expected output**: called handleChangeCurrentPlayer(playerIndex)

### Method under test: `handleChangeCurrentPlayer(int playerIndex)`
- **TC11: game not started, player index INT_MIN** ( :x: )
    - **Name of the test**:
    - **State of the system**: isGameOngoing = false, playerIndex = INT_MIN
    - **Expected output**: called game.changeCurrentPlayerAndSetFaceUpToFalse(playerIndex)

- **TC12: game not started, player index INT_MAX** ( :x: )
    - **Name of the test**:
    - **State of the system**: isGameOngoing = false, playerIndex = INT_MAX
    - **Expected output**: called game.changeCurrentPlayerAndSetFaceUpToFalse(playerIndex)

- **TC13: game not started, player index 0** ( :x: )
    - **Name of the test**:
    - **State of the system**: isGameOngoing = false, playerIndex = 0
    - **Expected output**: called game.changeCurrentPlayerAndSetFaceUpToFalse(playerIndex)

- **TC14: game not started, player index 1** ( :x: )
    - **Name of the test**:
    - **State of the system**: isGameOngoing = false, playerIndex = 1
    - **Expected output**: called game.changeCurrentPlayerAndSetFaceUpToFalse(playerIndex)

- **TC15: game not started, player index -1** ( :x: )
    - **Name of the test**:
    - **State of the system**: isGameOngoing = false, playerIndex = -1
    - **Expected output**: called game.changeCurrentPlayerAndSetFaceUpToFalse(playerIndex)

- **TC16: game started, player index INT_MIN** ( :x: )
    - **Name of the test**:
    - **State of the system**: isGameOngoing = true, playerIndex = INT_MIN
    - **Expected output**: called game.changeCurrentPlayerAndSetFaceUpToFalse(playerIndex)

- **TC17: game started, player index INT_MAX** ( :x: )
    - **Name of the test**:
    - **State of the system**: isGameOngoing = true, playerIndex = INT_MAX
    - **Expected output**: called game.changeCurrentPlayerAndSetFaceUpToFalse(playerIndex)

- **TC18: game started, player index 0** ( :x: )
    - **Name of the test**:
    - **State of the system**: isGameOngoing = true, playerIndex = 0
    - **Expected output**: called game.changeCurrentPlayerAndSetFaceUpToFalse(playerIndex)

- **TC19: game started, player index 1** ( :x: )
    - **Name of the test**:
    - **State of the system**: isGameOngoing = true, playerIndex = 1
    - **Expected output**: called game.changeCurrentPlayerAndSetFaceUpToFalse(playerIndex)

- **TC20: game started, player index -1** ( :x: )
    - **Name of the test**:
    - **State of the system**: isGameOngoing = true, playerIndex = -1
    - **Expected output**: called game.changeCurrentPlayerAndSetFaceUpToFalse(playerIndex)

### Method under test: `onDrawPile()`
- **TC21: game not started, draw pile empty** ( :x: )
    - **Name of the test**:
    - **State of the system**: isGameOngoing = false, drawPile = {}
    - **Expected output**: called game.drawFromPile()

- **TC22: game not started, draw pile has 1 card** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = false, drawPile = {SKIP}
  - **Expected output**: called game.drawFromPile()

- **TC23: game not started, draw pile has 2 different cards** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = false, drawPile = {SKIP, ATTACK}
  - **Expected output**: called game.drawFromPile()

- **TC24: game not started, draw pile has 2 equal type cards** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = false, drawPile = {SKIP, SKIP}
  - **Expected output**: called game.drawFromPile()

- **TC25: game started, draw pile empty** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = false, drawPile = {}
  - **Expected output**: called game.drawFromPile()

- **TC26: game started, draw pile has 1 card** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = false, drawPile = {SKIP}
  - **Expected output**: called game.drawFromPile()

- **TC27: game started, draw pile has 2 different cards** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = false, drawPile = {SKIP, ATTACK}
  - **Expected output**: called game.drawFromPile()

- **TC28: game started, draw pile has 2 equal type cards** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = false, drawPile = {SKIP, SKIP}
  - **Expected output**: called game.drawFromPile()

### Method under test: `onHandVisibilityButton()`
- **TC29: game not started, cards face down** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = false, isFaceUp = false
  - **Expected output**: called game.setIsFaceUpToOpposite()

- **TC30: game not started, cards face up** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = false, isFaceUp = true
  - **Expected output**: called game.setIsFaceUpToOpposite()

- **TC31: game started, cards face down** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = true, isFaceUp = false
  - **Expected output**: called game.setIsFaceUpToOpposite()

- **TC32: game started, cards face up** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = true, isFaceUp = true
  - **Expected output**: called game.setIsFaceUpToOpposite()

### Method under test: `onPlayerHandCardButton(int handCardIndex)`
- **TC33: game not started, cards face down, hand card index INT_MIN** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = false, isFaceUp = false, handCardIndex = INT_MIN
  - **Expected output**: called onFaceDownPlayerHandCardButton()

- **TC34: game not started, cards face up, hand card index INT_MIN** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = false, isFaceUp = true, handCardIndex = INT_MIN
  - **Expected output**: called onFaceUpPlayerHandCardButton(handCardIndex)

- **TC35: game started, cards face down, hand card index INT_MIN** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = true, isFaceUp = false, handCardIndex = INT_MIN
  - **Expected output**: called onFaceDownPlayerHandCardButton()

- **TC36: game started, cards face up, hand card index INT_MIN** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = true, isFaceUp = true, handCardIndex = INT_MIN
  - **Expected output**: called onFaceUpPlayerHandCardButton(handCardIndex)

- **TC37: game not started, cards face down, hand card index INT_MAX** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = false, isFaceUp = false, handCardIndex = INT_MAX
  - **Expected output**: called onFaceDownPlayerHandCardButton()

- **TC38: game not started, cards face up, hand card index INT_MAX** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = false, isFaceUp = true, handCardIndex = INT_MAX
  - **Expected output**: called onFaceUpPlayerHandCardButton(handCardIndex)

- **TC39: game started, cards face down, hand card index INT_MAX** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = true, isFaceUp = false, handCardIndex = INT_MAX
  - **Expected output**: called onFaceDownPlayerHandCardButton()

- **TC40: game started, cards face up, hand card index INT_MAX** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = true, isFaceUp = true, handCardIndex = INT_MAX
  - **Expected output**: called onFaceUpPlayerHandCardButton(handCardIndex)

- **TC41: game not started, cards face down, hand card index 0** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = false, isFaceUp = false, handCardIndex = 0
  - **Expected output**: called onFaceDownPlayerHandCardButton()

- **TC42: game not started, cards face up, hand card index 0** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = false, isFaceUp = true, handCardIndex = 0
  - **Expected output**: called onFaceUpPlayerHandCardButton(handCardIndex)

- **TC43: game started, cards face down, hand card index 0** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = true, isFaceUp = false, handCardIndex = 0
  - **Expected output**: called onFaceDownPlayerHandCardButton()

- **TC44: game started, cards face up, hand card index 0** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = true, isFaceUp = true, handCardIndex = 0
  - **Expected output**: called onFaceUpPlayerHandCardButton(handCardIndex)

- **TC45: game not started, cards face down, hand card index 1** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = false, isFaceUp = false, handCardIndex = 1
  - **Expected output**: called onFaceDownPlayerHandCardButton()

- **TC46: game not started, cards face up, hand card index 1** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = false, isFaceUp = true, handCardIndex = 1
  - **Expected output**: called onFaceUpPlayerHandCardButton(handCardIndex)

- **TC47: game started, cards face down, hand card index 1** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = true, isFaceUp = false, handCardIndex = 1
  - **Expected output**: called onFaceDownPlayerHandCardButton()

- **TC48: game started, cards face up, hand card index 1** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = true, isFaceUp = true, handCardIndex = 1
  - **Expected output**: called onFaceUpPlayerHandCardButton(handCardIndex)

### Method under test: `onFaceDownPlayerHandCard()`
- **TC49: game not started, cards face down** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = false, isFaceUp = false
  - **Expected output**: called onHandVisibilityButton()

- **TC50: game not started, cards face up** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = false, isFaceUp = true
  - **Expected output**: called onHandVisibilityButton()

- **TC51: game started, cards face down** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = true, isFaceUp = false
  - **Expected output**: called onHandVisibilityButton()

- **TC52: game started, cards face up** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = true, isFaceUp = true
  - **Expected output**: called onHandVisibilityButton()

### Method under test: `onFaceUpPlayerHandCardButton(int handCardIndex)`
- **TC53: game started, card is already in selected cards, hand card index 0** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = true, card = SKIP, selectedCards = {SKIP, SKIP}, handCards = {SKIP, SKIP}, handCardIndex = 0
  - **Expected output**: called game.removeCardFromSelectedCards(card)

- **TC54: game not started, card is not yet in selected cards, hand card index max** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = false, card = SKIP, selectedCards = {ATTACK}, handCards = {ATTACK, SKIP}, handCardIndex = 1
  - **Expected output**: called game.addCardToSelectedCards(card)

- **TC55: game started, card is already in selected cards, does not match with hand card at hand card index** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = true, card = SKIP, selectedCards = {SKIP}, handCards = {ATTACK}, handCardIndex = 0
  - **Expected output**: called IllegalStateException "Selected card does not match card in hand."

- **TC56: game not started, selected cards is empty, hand cards is empty, hand card index -1** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = false, card = SKIP, selectedCards = {}, handCards = {}, handCardIndex = -1
  - **Expected output**: called IndexOutOfBoundsException

- **TC57: game started, selected cards is empty, hand cards is empty, hand card index max+1** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = true, card = SKIP, selectedCards = {SKIP, SKIP}, handCards = {SKIP, SKIP}, handCardIndex = 2
  - **Expected output**: called IndexOutOfBoundsException

### Method under test: `onStartGameButton()`
- **TC58: game started, current player is not starting player** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = true, startingPlayerIndex = 0, currentPlayerIndex = 1
  - **Expected output**: called game.handleChangeCurrentPlayer(startingPlayerIndex)

- **TC59: game not started, current player is not starting player** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = false, startingPlayerIndex = 1, currentPlayerIndex = 0
  - **Expected output**: called game.handleChangeCurrentPlayer(startingPlayerIndex)

- **TC60: game started, current player is starting player** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = true, startingPlayerIndex = 0, currentPlayerIndex = 0
  - **Expected output**: called game.handleChangeCurrentPlayer(startingPlayerIndex)

- **TC61: game not started, invalid starting player index** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = false, startingPlayerIndex = -1, currentPlayerIndex = 0
  - **Expected output**: called game.handleChangeCurrentPlayer(startingPlayerIndex)

- **TC62: game started, invalid current player index** ( :x: )
  - **Name of the test**:
  - **State of the system**: isGameOngoing = true, startingPlayerIndex = 0, currentPlayerIndex = -1
  - **Expected output**: called game.handleChangeCurrentPlayer(startingPlayerIndex)

