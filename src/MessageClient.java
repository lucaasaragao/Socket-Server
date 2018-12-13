import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MessageClient {
	
	// LUCAS ARAGÃO

	public static String DEFAULT_SERVER_HOST = "127.0.0.1"; //meu ip
	public static String DEFAULT_SERVER_PORT = "9999"; //porta
	private static DataInputStream in;
	private static DataOutputStream out;
	public static String msg = "Deu bom";
	
	
	public static void main(String[] args) throws UnknownError, IOException  {
		// Argumentos do programa: <IP do servidor> <Porta do servidor> 
		String serverHost = args.length > 0 ? args[0] : DEFAULT_SERVER_HOST;
		int serverPort = args.length > 1 ? Integer.parseInt(args[1]) : MessageServer.DEFAULT_PORT;
		
		
		//Agora é com voces ...
		
		Socket a = new Socket(args[0],Integer.parseInt(args[1]));
		if(a.isConnected())
		{
			System.err.println(" A conexão foi um sucesso!");
		}
		
		out = new DataOutputStream(a.getOutputStream());
	 	in = new DataInputStream(a.getInputStream());
	 	System.out.println("Aguarde, estamos enviando mensagem para: " + a.getInetAddress() + ":" + args[1]);
		//mensagem sendo enviada ao server 
	 	out.writeUTF(msg);
	 	String conteudo = in.readUTF();
	 	System.out.println("A resposta de sua requisição é: "+ conteudo);
	 	out.writeUTF(conteudo);
	}
		
}



