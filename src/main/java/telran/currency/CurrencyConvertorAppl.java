package telran.currency;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONObject;

import telran.currency.service.CurrencyConvertor;
import telran.currency.service.FixerApiPerDay;
import telran.view.Item;
import telran.view.Menu;
import telran.view.SystemInputOutput;

public class CurrencyConvertorAppl {
	
	public static void main(String[] args) throws Exception {
		try {
          
            CurrencyConvertor convertor = new FixerApiPerDay();    
            CurrencyItems items = new CurrencyItems(convertor);
            Menu menu = new Menu("Currency exchange", items.getItems().toArray(Item[]::new));  
            menu.perform(new SystemInputOutput());
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
}