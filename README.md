
Proje sadece backend olarak oluşturulmuştur.

Heroku'ya Deploy edildi --> https://springboot-restful-todo-back.herokuapp.com


/user		(get)
/user/register	(post) --->	{
   			   "username"   : string
    			   "password"   : string
    			   "cpassword" : string
			}
/user/login	(post) --->	{
   			   "username" : string
    			   "password" : string
			}
todolist	           	(post) --->	{
   			   "text"    : string
    			   "userid" : int
    			   "status" : true/false
			}
todolist/{todoid} 	(put) --->	{
   			   "text"    : string
    			   "userid" : int
    			   "status" : true/false
			}
todolist/{userid} 	(get)
todolist/{todoid} 	(delete)	 
