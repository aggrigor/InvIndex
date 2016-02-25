
package invindex;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.Vector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
//import java.util.StringTokenizer;

/**Inverted Index Project for I.R - uth
 * 
 * @author Aggeliki Grigoropoulou
 * 
 * Spring Semester 2014
 */

public class index
{
        static String path;
        static String fname;
        static int NoDocs;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        path = "C:\\Documents and Settings\\Angie\\Επιφάνεια εργασίας\\reuters21578\\reut2-021.sgm";
        fname =  path ;
        
        try 
        {  
            /*ReadFile f = new ReadFile(fname);
            String[] lines = f.OpenFile();*/
          
            BufferedReader sr = new BufferedReader(new FileReader(fname));
            StrTokenizer n = new StrTokenizer();
            String[] tok =  n.Openfile();
            Vector<Integer> vec = n.posArray();
            
            
            
            ArrayList docs ;
            
            NoDocs = n.retNoDocs();
            System.out.println("Number of Documents :"+ NoDocs);
            
            DocParse ar = new DocParse();
            docs = ar.returnDocs(tok);
            
            //InvertedIndex in = new InvertedIndex();
            //in.ReadDocs();
           // in.search();
      
            Frequencies t =new Frequencies();
            t.TFperDoc();
        
            //print group : array of docs  
          /* int i = 1;
            
            Iterator it = docs.iterator(); 
            while(it.hasNext())
            {
                System.out.println("DocID "+i+" : "+ it.next());
                i++;
            } */ 
            //Query
          /*  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Search for a term:");

            String q = br.readLine();
            System.out.println("you asked for : "+q);
            br.close();*/
            
           
            
          /*parse file with StringTokenizer*/
          
            
         /* int i;
            int j = 0;
            String delims = " \n\t{}()-_/<>\\,.?:;!''=&#\"";  
            String emptyStr = "";
            int maxarlength = 120000;
            String[] terms ;
            terms = new String[maxarlength]; 
            
            for (i=0; i<lines.length; i++)
            {
               // System.out.println(lines[i]);
                StringTokenizer st = new StringTokenizer(lines[i],delims);
                while(st.hasMoreTokens()&&(j<maxarlength))
                {
                   String term = st.nextToken();
                   if (!term.equalsIgnoreCase(emptyStr))
                   {
                            terms[j] = term;  
                   }
                   j++;
                }
            }
            for (i=0; i<terms.length; i++)
            {
                 System.out.println(terms[i]);
            }*/
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}
