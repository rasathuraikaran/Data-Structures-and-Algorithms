package NameScores;
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class NameScores {


    public static int score(List<String> namelist,List<String> scoreNamelist){
        int score=0; // initially set a score as zero
        Collections.sort(namelist);// sort the list by alphabetical order
        // for(int i=0; i<namelist.size();i++) System.out.println(namelist.get(i));




        for(int k=0;k<scoreNamelist.size();k++){
            for(int m=0;m<namelist.size();m++){
                if(scoreNamelist.get(k).equals(namelist.get(m))){

                    char[] ch = namelist.get(m).toCharArray();


                    int dumScore=0;
                    for(int j=0;j<ch.length;j++){

                        dumScore=(ch[j]-'A'+1)+dumScore;



                    }


                    score=(dumScore*(m+1));
                    System.out.println(score);


                }
            }


        }


        return score;



    }

    public static void main(String[] args) {
        Scanner ui=new Scanner(System.in);
        List<String> namelist=new ArrayList<String>();
        int len=ui.nextInt();
        for (int i=0;i<len;i++){
            String name=ui.next().toUpperCase();
            namelist.add(name);
        }
        List<String> scorNamelist=new ArrayList<String>();
        int lent=ui.nextInt();
        for (int i=0;i<lent;i++){
            String name=ui.next();
            scorNamelist.add(name);
        }

        int out=score(namelist,scorNamelist);



    }
}
