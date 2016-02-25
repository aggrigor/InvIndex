
package invindex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

/**Inverted Index Project for I.R - uth
 *
 * @author Aggeliki Grigoropoulou
 * 
 * Spring Semester 2014
 */

public class InvertedIndex 
{
    int i;
    int j;
    int N;  //number of documents
    StrTokenizer strt;
    DocParse d;
    ArrayList<ArrayList<String>> ar; //array of documents
    ArrayList<String> line;
    TreeMap<String, Integer> tm;
    String term[];
    int tf;       //number of occurences of the term in the file
    String q;
    
    //Constructor
    public InvertedIndex()
    {
            i = 0;
            j = 0;
            strt = new StrTokenizer();
            N = strt.retNoDocs();
            d = new DocParse();
            line = new ArrayList();
            
            
            try
            {
                     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                     System.out.println("Search for a term:");
        
                     q = br.readLine();
                     System.out.println("you asked for : "+q);
                     br.close();

                     term = strt.Openfile();
                     ar = d.returnDocs(term);
            }
            catch(IOException e)
            {
                     System.out.println(e.getMessage());
            }
    }

    public void ReadDocs()
    {
            tm= new TreeMap<>();
            
            

            Iterator it = ar.iterator();
            while(it.hasNext())
            {   
                     line = (ArrayList)ar.get(i);
                     
                    //System.out.println(line);
                    // System.out.println("Document size :"+line.size());
                     for(j=0; j<line.size(); j++)
                     {
                             if((String)line.get(j)== null)
                                 break;
                             term[j] = (String)line.get(j);
                             
                             //System.out.println("term "+j+" : "+term[j]); 
                             tm.put(term[j], getCount(term[j],tm)+1);  
                             
                           //  dfmap.put(term[i], i);
                             
                     }
                     it.next();
                     i++;
            }
            printCounts(tm);
    }

    public void printCounts(TreeMap<String, Integer> f)  
    {  
            System.out.println("--------------INVERTED  INDEX------------------");  
            System.out.println("   TF    Term");  
   
            for(String word : tm.keySet( ))  
            {  
                     System.out.printf("%5d    %s\n", tm.get(word), word);  
            }  
            System.out.println("-----------------------------------------------");  
    }

    public int getCount(String term, TreeMap<String, Integer> tm)
    {
            if (tm.containsKey(term))
            {  
                     return tm.get(term); 
            }
            else
            {    
                     return 0;
            }
    }

    public void search()
    {                 
               if(tm.containsKey(q))
               {
                   System.out.println("the word -> "+q+" <- was found in the file.");  
               }  
               else
               {
                   System.out.println(q+" not found");
               }
    }
}
