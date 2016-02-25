package invindex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**Inverted Index Project for I.R - uth
 *
 * @author Aggeliki Grigoropoulou
 * AEM : 699
 * 
 * Spring Semester 2014
 */

public class Frequencies
{
    int i,j;
    DocParse docs;
    Map<String, Map<String,Integer>> file;
    ArrayList<ArrayList<String>> DocArray;
    String Docs[];
    ArrayList<String> line;
    Map<String, Integer> tm;
    Map<String, Integer> idfmap;
    String term[];
    StrTokenizer s;
    String q;
    int df;
    int dfpartic;
    Map<String,Integer> dfmap;
    
    //Constructor
    public Frequencies()
    {
            i = j = 0;
            file = new TreeMap<String, Map<String,Integer>>();
            docs = new DocParse();
            DocArray = new ArrayList<>(578);
            line = new ArrayList();
            s = new StrTokenizer();
            Docs = new String[578];
            df = 0;
          
            try
            {
                  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                  System.out.println("Search for a term:");
        
                  q = br.readLine();
                  System.out.println("you asked for : "+q);
                  br.close();
              
                  term = s.Openfile();
                  DocArray = docs.returnDocs(term);
            }
            catch(IOException e)
            {
                  System.out.println(e.getMessage());
            }   
    }
    
    public void TFperDoc()
    {  
            HashSet<String> all_terms = new HashSet<String>();
         
            Iterator it = DocArray.iterator();
            while(it.hasNext())
            {      
                   line = (ArrayList)DocArray.get(i);
                   Docs[i]= "Document "+i; 
                   
                  // System.out.println(Docs[i]);
                  // System.out.println(line);
                  // System.out.println("Document size :"+line.size());
                   tm = new TreeMap<>();
                   for(j=0; j<line.size(); j++)
                   {
                         if((String)line.get(j)== null)
                                 break; 
                         term[j] = (String)line.get(j);
                         tm.put(term[j],getCount(term[j],tm)+1); 
                         all_terms.add(term[j]);
                   }
  
                   file.put(Docs[i],tm);
                   //dfmap.put(term[j],dfCount(term[j],tm));
                   it.next();
                   i++;
            } 
            dfCount(file, all_terms);
            //print(file);
            searchDocs(file);
    }
    public int getCount(String term, Map<String, Integer> tm)
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
    public void dfCount(Map<String, Map<String, Integer>> file,  Set allTerms)
    { 
            dfmap = new TreeMap<>();
            
            df = 0;
 
            for(Object t: allTerms)
            { 
                String leksi = (String) t;      
                df = 0;
                for(String doc : file.keySet())
                {
                    //if((file.get(doc))==null)
                    //       break;
                    if((file.get(doc)).containsKey(leksi))
                    {
                           df=df+1;
                           dfmap.put(leksi,df);
                    }
                }    
            }
           
            printn(dfmap);
            idfCount(dfmap);
    }
    public void idfCount(Map<String, Integer> dfm)
    {
            idfmap = new TreeMap<>();
            double idf;
            int N = 578;
            
            for(String oros : dfm.keySet())
            {
                    idf = Math.log(N/dfm.get(oros));
                    idfmap.put(oros,(int)idf);
            }
            printn(idfmap);
    }
            
    public void print(Map<String, Map<String,Integer>> f)  
    {  
            System.out.println("--------------INVERTED  INDEX------------------");  
            System.out.println("doc :   Term    TF");  
   
            for(String word : f.keySet())  
            {  
                     System.out.printf("%s   %s \n",word, f.get(word));  
            }  
            System.out.println("-----------------------------------------------");  
    }
    public void printn(Map<String,Integer> f)  
    {  
            System.out.println("--------------INVERTED  INDEX------------------");  
            System.out.println("           Term     DF");  
   
            for(String word : f.keySet())  
            {  
                     System.out.printf("%15s    %d \n",word, f.get(word));  
            }  
            System.out.println("-----------------------------------------------");  
    }
    
    public void searchDocs(Map<String, Map<String,Integer>> file)
    {          
            for(String word : file.keySet())  
            {      
                    if((file.get(word)).containsKey(q))
                    {

                            System.out.println("found in: "+word);
                            dfpartic= dfpartic+1;
                           // System.out.println("the word -> "+q+" <- was found in the file: "+word);  
                    }  
                    else
                    {
                           // System.out.println(q+" not found in "+word);
                    }
             }
             System.out.println("the word you asked was found in "+dfpartic+" documents.");
    }
}