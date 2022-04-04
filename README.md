# PLACE2LIVE API 

## URL endpoints


#### URL 1
##### Name: login Url
###### Location localhost:8080/API/checkLogin
##### Method: POST
##### Return Type: int

###### this url expects json data in the following format. where "id" is the user's id (an int) and password is their password (string). in return, it returns 0 or 1 depending on whether the login was successful or not
	{
      "id":1235,
      "password":234
    }
    
    
    
    
#### URL 2
##### Name: Create User Url
###### Location localhost:8080/API/createUser
##### Method: POST
##### Return Type: int
###### this url expects json data in the following format. where "id" is the user's id (an int) and password is their password (string). in return, it returns 0 or 1 depending on whether the user was successfully created or not
	{
      "id":"Integer",
      "userName":"String",
      "password":"String",
      "emailAddress":"String",
      "isAdmin":"Int(0,1)"
    }
    
    
 #### URL 3
##### Name: Get All Posts Url
###### Location localhost:8080/API/allPosts
##### Method: GET
##### Return Type: an itterable of Post objects
###### this url returns a list of json data in the following format. it does not receive any json data. the data it returns is in this form
	[
    {
        "id": 1,
        "postCategory": "lol",
        "postAddress": "145 ww f",
        "posterId": 12234
    },
    {
        "id": 2,
        "postCategory": "lol",
        "postAddress": "145 ww f",
        "posterId": 12234
    },
    .....
    ]
    
    
    
   #### URL 4
##### Name: Create Post Url
###### Location localhost:8080/API/createPost
##### Method: POST
##### Return Type: an Int (0,1) indicating whether the post was created successfully or not
###### the json data it expects is in this form 


	{    
        "postCategory": "String",
        "postAddress": "String",
        "posterId": "Int"
    }
    
    
    
   #### URL 5
##### Name: Edit Post Url
###### Location localhost:8080/API/editPost/{id}
##### Method: POST
##### Return Type: String indicating what happend. 
	"SUCCESS": if the post was edited successfully
    "Post ID does not exist": if the user is trying to edit a post that doesnt exist
    "You can only edit posts You made": if the user is trying to edit a post they didnt post
###### the json data it expects is in this form. and the {id} in the url is the id of the post being edited (int). every field doesn't have to be provided. if they aren't then those fields are simply not edited. but the "posterId" field MUST be provided


	{    
        "postCategory": "String",
        "postAddress": "String",
        "posterId": "Int"
    }
