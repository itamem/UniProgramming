import java.util.LinkedList;

public class Administrators {
    LinkedList<Administrator> administrators;

    public Administrators() {
      administrators = new LinkedList<Administrator>();
      insertDummyData();
    }
    public void insertDummyData() {
        administrators.add(new Administrator("David Dyer", "david46@uts.com", "123"));
        administrators.add(new Administrator("Angela Huo", "angela123@uts.com", "mypw"));
    }

    public LinkedList<Administrator> getAdministrators() {
        return administrators;
    }

      public Administrator lookup(String login, String password) {
      for (Administrator admin : administrators) {
        if (login.equals(admin.getLogin())) {
          if (password.equals(admin.getPassword())) {
            return admin;
          }
        
        }
      }
        return null;
      }

     
    //for every administrator in administrators chec if they match

//use a lookup method
//if administrators.contain(insertDummyData() && a)
//what this does is, it checks if the details input by the user match the 
//the dummydata login and password details. What we need to do next is go back to login()
    // public Administrator LogDetails(String login, String password) {
    // for (Administrator LogDetails: administrators)
    //   if (LogDetails.getLogin().contains(login)) {
    //     if (LogDetails.getPassword().contains(password)) {
    //       matches.add(LogDetails);
    //   }
    // }
    //   return matches;
    // }

}//surely this is correct^?

//hold on, do i need to create anew list?