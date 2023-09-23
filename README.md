# SpringSample
SpringSample is a Kotlin Spring TodoList Project with in memory database, consist of 3 apis.

# /todo
a GET method to retrive the list of todo list with no required paramethers

# /todo
a POST method to save a todo item. this api call will returned the saved object with assigned id

## request body:
```json
{
    "name":"go to school", // name of the task
    "date":"2023/09/18 19:23" // date in YYYY/MM/DD HH:mm format
}
```

## response body:
```json
{
    "message": "inserted",
    "response": {
        "id": 1,
        "name": "go to school",
        "date": "2023/09/18 19:23"
    }
}
```

# /todo/{id}
a DELETE method to delete an specific todo item, requires a valid id
