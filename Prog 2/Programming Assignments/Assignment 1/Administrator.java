import java.util.LinkedList;

public class Administrator {
    private String name;
    private String login;
    private String password;
   

    public Administrator(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
       
    }
    public String getName() {
        return this.name = name;
    }
     public String getLogin() {
        return this.login = login;
     }
      public String getPassword() {
        return this.password = password;
      }

       public boolean hasLoginDetails(String login, String password) {
         return login.equals(this.login) && password.equals(this.password);
       }

    //   public boolean hasPassword(String password) {
    //     return ;
    //   }
      // public String readLogin() {
      //   System.out.println("Username:");
      //   return Utils.nextLine();
      // }
    

}