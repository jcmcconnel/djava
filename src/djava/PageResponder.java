package djava;
import java.io.File;
import java.nio.file.Files;
import java.io.IOException;

public class PageResponder extends Responder
{
   private String root;

   public PageResponder(String ep, String root)
   {
      super(ep);
      this.root = root;
   }

   protected String getBody(String target) throws ResponderError
   {
      String body = "";
      File resource;
      File ep = new File(root+this.getEndPoint()+"/index.html");
      resource = new File(root+this.getEndPoint()+this.path+"/index.html");

      
      try {
         if(resource.exists()) body = Files.readString(resource.toPath());
         else throw new ResponderError("Path does not exist");
      }
      catch(IOException e) {
         System.out.println(e);
      }
      return body+"\n";
   }
   
}

