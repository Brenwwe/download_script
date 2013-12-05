import java.io.FileOutputStream;

import java.io.IOException;

import java.io.InputStream;

import java.net.URL;

 

public class JavaDownloadFile {

 

    public static void main(String[] args) {

        try {

            JavaDownloadFile downloader = new JavaDownloadFile();

            downloader.download("http://www.curseforge.com/media/files/749/98/buildcraft-A-1.6.2-4.1.2.jar", "C:\\Users" + "/" + System.getProperty("user.name") + "/" + "AppData/Roaming/.minecraft/mods");

            downloader.download("http://download1644.mediafire.com/vdvscpi3ycyg/a7k3ri7nbd3gamy/EJ1.6.4B.zip", "C:\\Users" + "/" + System.getProperty("user.name") + "/" + "AppData/Roaming/.minecraft/mods");

            
             

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

     

    /**

     * Method downloads file from URL to a given directory.

     * @param fileURL   -   file URL to download

     * @param destinationDirectory  - directory to download file to

     * @throws IOException

     */

    private void download(String fileURL, String destinationDirectory) throws IOException {

        // File name that is being downloaded

        String downloadedFileName = fileURL.substring(fileURL.lastIndexOf("/")+1);

         

        // Open connection to the file

        URL url = new URL(fileURL);

        InputStream is = url.openStream();

        // Stream to the destionation file

        FileOutputStream fos = new FileOutputStream(destinationDirectory + "/" + downloadedFileName);

  

        // Read bytes from URL to the local file

        byte[] buffer = new byte[4096];

        int bytesRead = 0;

         

        System.out.print("Downloading " + downloadedFileName);

        while ((bytesRead = is.read(buffer)) != -1) {

            System.out.print(".");  // Progress bar :)

            fos.write(buffer,0,bytesRead);

        }

        System.out.println("done!");

  

        // Close destination stream

        fos.close();

        // Close URL stream

        is.close();

    }   

}
//- See more at: http://www.itcuties.com/java/download-file/#sthash.WS6BWpGo.dpuf
