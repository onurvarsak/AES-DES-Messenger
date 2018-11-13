import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

public class Server {

    private static final int PORT = 6565;

    private static HashSet<String> clientNames = new HashSet<String>();
    private static HashSet<PrintWriter> clientWriters = new HashSet<PrintWriter>();
    private static int id = 0;
    private static String method;
    private static String mode;

    public static void main(String[] args) throws Exception{
        System.out.println("Server running...");
        ServerSocket listener = new ServerSocket(PORT);


        try{
            while (true){
                Handler h = new Handler(listener.accept());
                h.start();
            }
        }finally {
            listener.close();
        }

    }

    private static class Handler extends Thread{
        private String name;
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public Handler(Socket socket){
            this.socket = socket;
        }
        public void run(){
            try{

                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(),true);

                while(true){
                    out.println("ID:"+(++id));
                    if(id == 1){
                        String line = in.readLine();
                        if(line.startsWith("METHOD:"))
                            method = line.substring(7);
                        line = in.readLine();
                        if(line.startsWith("MODE:"))
                            mode = line.substring(5);
                    }
                    else{
                        out.println("METHOD:"+method);
                        out.println("MODE:"+mode);
                    }

                    out.println("USERNAME");
                    name = in.readLine();
                    if(name == null)
                        return;
                    synchronized (clientNames){
                        if(!clientNames.contains(name)){
                            clientNames.add(name);
                            break;
                        }
                    }
                }
                out.println("NAMEOK");
                clientWriters.add(out);

                while (true){
                    String input = in.readLine();
                    if(input == null)
                        return;
                    for(PrintWriter writer : clientWriters)
                        writer.println("MESSAGE"+ name +": "+input);
                }
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                if(name!=null){
                    clientNames.remove(name);
                    out.println("ID:"+(--id));
                }
                if(out!=null)
                    clientWriters.remove(out);
                try{
                    socket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }


}
