public class Runner {
   public static void main(String[] args) {
    // String add ="a1";
    // String[] part = add.split("(?<=\\D)(?=\\d)"); 
    // int num1 = Integer.parseInt(part[1]);
    // char c =add.charAt(0);
    // num1++;
    // String comb = c + Integer.toString(num1);
    // System.out.println(comb);
    // System.out.println(c);
    // System.out.println(num1);

    //go to the next letter method?

    //goal: create a nested for loop that can successfully
    //add 1 to the int of the coordinates.
    //coordinates though...?
 

 //   int numRows = 10;
 //   int numCols = 10;
    
   //  String pos = "a1";
   //  String [][] map = new String[10][10];
   //  for (int i = 0; i < 10; i++) {
   //      for (int j = 0; j < 10; j++) {
   //              map[i][j] = pos;
                
   //              System.out.println(pos);
   //              String[] part = pos.split("(?<=\\D)(?=\\d)"); 
   //              int num1 = Integer.parseInt(part[1]);
   //              char c =pos.charAt(0);              
   //              num1++;
   //              pos = c + Integer.toString(num1);
            
   //          }
            
   //          int num1 = 1;
   //          char c =pos.charAt(0); 
   //          c++;              
   //          pos = c + Integer.toString(num1);
   //      }
  
        String board = "  1 2 3 4 5 6 7 8 9 10\n";
        char r = 'A';
        
        for (int i = 0; i < 10; i++) {
         board += r + " "; 
            for (int j = 0; j < 10; j++) {
               board += " .";
            }
            r++;
            board+= "\n";
            
           
        }

             System.out.print(board.trim());
            
        
    
   }
}
