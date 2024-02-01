import java.util.*;
class Main
{
    public static void main(String args[])
    {
        System.out.println("INSTRUCTION.....INITIALLY  ALL FIELDS OF THE BOARD  WILL  BE  FILLED WITH  9\n");
        System.out.println("BY DEFAULT PLAYER  SIGN  IS 1 AND  COMPUTER  SIGN IS  0\n");
        System.out.println("PLAYER  HAVE  TO  ENTER  ONLY  THE  COORDINATES  OF  BOARD");
        System.out.println("For win the game...1 point will be provided");
        System.out.println("No point will be provided for loss and draw");
        System.out.println("LAST  BUT  NOT LEAST.......ENJOY\n");

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter how many round you want to play : ");
        int round=sc.nextInt();
        int man_point=0,comp_point=0,round_count=1;

        while(round!=0)
        {
            System.out.println("Round : "+round_count);

            System.out.println("Choose board size");
            System.out.print("Enter 3 for 3*3....4 for 4*4....5 for 5*5...and so on..\nEnter your choice : ");
            int size=sc.nextInt();

            Tic_Tac_Toe obj=new Tic_Tac_Toe(size);
            int i,check=9, diag_check=9;

            for(i=1;i<=size*size;i++) {
                if (i % 2 == 0) {
                    System.out.println("Wait for computer turn..");
                    System.out.println("Comp turn....");
                    obj.comp_turn();
                    check = obj.checker();
                    diag_check = obj.diagonal_checker();

                    if (check == 1 || check == 2 || diag_check == 1 || diag_check == 2) {
                        break;
                    }
                    obj.display();
                } else {
                    System.out.println("User turn......");
                    obj.help_func();
                    obj.manual_turn();
                    check = obj.checker();
                    diag_check = obj.diagonal_checker();

                    if (check == 1 || check == 2 || diag_check == 1 || diag_check == 2) {
                        break;
                    }
                    obj.display();
                }
            }
            System.out.println("\nFinal board pos \n");
            obj.display();

            if(check==1||diag_check==1)
            {
                System.out.println("\nCongratulation.........User win");
                man_point++;
            }
            else if(check==2||diag_check==2)
            {
                System.out.println("\nGame over.................Computer win");
                comp_point++;
            }
            else
            {
                System.out.println("Match draw");
            }
            round=round-1;
            round_count=round_count+1;
        }
        System.out.println("Ultimate result...\nUser : Computer = "+man_point+" : "+comp_point);
    }
}