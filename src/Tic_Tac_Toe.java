import java.util.*;
class Tic_Tac_Toe
{
    Scanner sc=new Scanner(System.in);
    int a[][];
    int r;
    int ran_row,ran_col;
    Tic_Tac_Toe(int r)
    {
        this.r=r;
        a=new int[r][r];
        int i,j;
        for(i=0;i<r;i++)
        {
            for(j=0;j<r;j++)
            {
                a[i][j]=9;
            }
        }
    }

    void generate()
    {
        int i=0;
        ran_row=(int)(Math.random()*r);
        ran_col=(int)(Math.random()*r);
        if(a[ran_row][ran_col]==0||a[ran_row][ran_col]==1)
        {
            generate();
        }
    }

    void comp_turn()
    {
        generate();
        a[ran_row][ran_col]=0;
    }

    void manual_turn()
    {
        int man_row,man_col;
        System.out.print("Enter coordinates : ");
        man_row=sc.nextInt();
        man_col=sc.nextInt();
        if(a[man_row][man_col]==0||a[man_row][man_col]==1)
        {
            System.out.println("Wrong move...Enter again:");
            manual_turn();
        }
        else
        {
            a[man_row][man_col]=1;
        }
    }

    void display()
    {
        int i,j;
        for(i=0;i<r;i++)
        {
            for(j=0;j<r;j++)
            {
                System.out.print(+a[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    int  checker()
    {
        int one_count=0;
        int zero_count=0;
        int i,j,flag=0;
        for(i=0;i<r;i++)
        {
            one_count=0;
            zero_count=0;
            for(j=0;j<r;j++)
            {
                if(a[i][j]==1)
                {
                    one_count++;
                }
                if(a[i][j]==0)
                {
                    zero_count++;
                }
            }
            if(one_count==r||zero_count==r)
            {
                flag=1;
                break;
            }
        }
        if(i==r)
        {
            for(j=0;j<r;j++)
            {
                one_count=0;
                zero_count=0;
                for(i=0;i<r;i++)
                {
                    if(a[i][j]==1)
                    {
                        one_count++;
                    }
                    if(a[i][j]==0)
                    {
                        zero_count++;
                    }
                }
                if(one_count==r||zero_count==r)
                {
                    flag=1;
                    break;
                }
            }
        }
        if(flag==1)
        {
            if(one_count==r)
            {
                return 1;
            }
            else
            {
                return 2;
            }
        }
        else
        {
            return 0;
        }
    }


    int diagonal_checker()
    {
        int i;
        int moc=0,mzc=0,roc=0,rzc=0;
        for(i=0;i<r;i++)
        {
            if(a[i][i]==1)
            {
                moc++;
            }
            if(a[i][i]==0)
            {
                mzc++;
            }
            if(a[i][r-i-1]==1)
            {
                roc++;
            }
            if(a[i][r-i-1]==0)
            {
                rzc++;
            }
        }
        if(moc==r||mzc==r||roc==r||rzc==r)
        {
            if(moc==r||roc==r)
            {
                return 1;
            }
            else
            {
                return 2;
            }
        }
        else
        {
            return 0;
        }
    }
    void help_func()
    {
        int i,j;
        System.out.print("Available coordinates : ");
        for(i=0;i<r;i++)
        {
            for(j=0;j<r;j++)
            {
                if(a[i][j]!=0&&a[i][j]!=1)
                {
                    System.out.print("("+i+" "+j+")"+" ");
                }
            }
        }
        System.out.println();
    }
}

