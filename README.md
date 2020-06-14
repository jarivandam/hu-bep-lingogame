# hu-bep-lingogame
# Build status
![Github build only](https://github.com/jakah/hu-bep-lingogame/workflows/Build%20only/badge.svg)
[![codecov](https://codecov.io/gh/jakah/hu-bep-lingogame/branch/master/graph/badge.svg?token=F0BA6WXTOU)](https://codecov.io/gh/jakah/hu-bep-lingogame)

Master is deployed to: [https://hu-bep-lingogame.herokuapp.com](https://hu-bep-lingogame.herokuapp.com/games/)
# Game
The game exists of games with one or more rounds. In each round you got 5 turns to gues the right word. 


# Rest api
## Games
| Endpoint    | Method | Body | Response                        | Description       |
|-------------|--------|------|---------------------------------|-------------------|
| /games      | GET    |      |``` json [ { "id": 1 }, { "id": 9306 } ]```| List of all games |
| /games      | POST   |      |``` json { "id": 9306 } ```                 | Start a new game  |
| /games/{id} | GET    |      | ``` json{ "id": 1 } ```                    | Get single game   |

## Round
| Endpoint         | Method | Body | Response                        | Description        |
|------------------|--------|------|---------------------------------|--------------------|
| /rounds          | GET    |      | ``` json [ { "id": 1 }, { "id": 9306 } ]``` | List of all rounds |
| /rounds/{gameId} | POST   |      | ``` json {"game": { "id": 9309 }, "turnsPlayed": 0 }``` | Start a new round  |
| /rounds/{id}     | GET    |      | ```json { "id": 9313,"game": {"id": 9309 }, "turnsPlayed": 0 }```  | Get single round   |


## Turn
### Get list of all Turns
#### Request
`GET /turns`
#### Response
``` json [
   [
     {
       "guessedWord": {
         "id": 18,
         "word": "aanbrug"
       },
       "round": {
         "id": 9313,
         "game": {
           "id": 9309
         },
         "turnsPlayed": 2
       }
     },
     {
       "guessedWord": {
         "id": 641,
         "word": "beleerd"
       },
       "round": {
         "id": 9313,
         "game": {
           "id": 9309
         },
         "turnsPlayed": 2
       }
     }
   ]
```
### Make a new Turn
#### Request
`POST /round/{roundId}/turns`

```json { "guessedWord": "aanbrug"  }``` 

#### Response
``` json ["FAULT","FAULT","CONTAINS","FAULT", "FAULT","CONTAINS", "FAULT"] ```

### Get single turn
#### Request
`GET /turns/{id}`
#### Response
``` json{ "id": 1 } ```

