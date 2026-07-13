package randompokemon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/generate")
public class servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = (int)(Math.random() * 1025) + 1;
		
		URL url = new URL("https://pokeapi.co/api/v2/pokemon/" + id);
		
		HttpURLConnection con =(HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		String line;
		StringBuilder result = new StringBuilder();
		
		while((line = br.readLine()) != null ) {
			result.append(line);
		}
		
		br.close();
		
		Gson gson = new Gson();

		JsonObject pokemon = gson.fromJson(result.toString(),JsonObject.class);
		
		JsonArray results = pokemon.getAsJsonArray("results");
		
		String name = pokemon.get("name").getAsString();
		
		JsonObject sprites = pokemon.getAsJsonObject("sprites");
		String image = sprites.get("front_default").getAsString();
				
		req.setAttribute("name", name);
		req.setAttribute("image", image);
		RequestDispatcher rd = req.getRequestDispatcher("NewFile.jsp");

        rd.forward(req, resp);
		
	}
	
}
