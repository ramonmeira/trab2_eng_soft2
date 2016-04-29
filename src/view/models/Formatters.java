package view.models;

import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import javax.swing.text.MaskFormatter;

public class Formatters {
	
	public DateFormatter dateDisplayFormat;
	public DateFormatter dateEditFormat;
	
	public NumberFormatter displayPreco;
	public NumberFormatter editDecimal;
	public NumberFormatter editInteger;
	
	public MaskFormatter sixDigitDisplay;
	public MaskFormatter cnpjDisplay;
	public MaskFormatter cpfDisplay;
	public MaskFormatter celularDisplay;
	public MaskFormatter telefoneDisplay;
	
	public DefaultFormatterFactory precoFormat;
	public DefaultFormatterFactory dateFormat;
	public DefaultFormatterFactory cpfFormat;
	public DefaultFormatterFactory cnpjFormat;
	public DefaultFormatterFactory idFormat;
	
	public Formatters() {		
		try {
			dateDisplayFormat = new DateFormatter(new SimpleDateFormat("dd/MM/yyyy"));
			dateEditFormat = new DateFormatter(new SimpleDateFormat("ddMMyyyy"));
			dateFormat = new DefaultFormatterFactory(dateDisplayFormat, dateDisplayFormat, dateEditFormat);
			
			displayPreco = new NumberFormatter(NumberFormat.getCurrencyInstance());
			editDecimal = new NumberFormatter(new DecimalFormat("#,##0.##"));
			editInteger = new NumberFormatter(NumberFormat.getIntegerInstance());
			
			sixDigitDisplay = new MaskFormatter("######");
			cnpjDisplay = new MaskFormatter("##.###.###/####-##");
			cpfDisplay = new MaskFormatter("###.###.###-##");
			celularDisplay = new MaskFormatter("(##) # ####-####");
			telefoneDisplay = new MaskFormatter("(##) ####-####");
			
			dateFormat = new DefaultFormatterFactory(dateDisplayFormat, dateDisplayFormat, dateEditFormat);
			precoFormat = new DefaultFormatterFactory(displayPreco, displayPreco, editDecimal);
			cnpjFormat = new DefaultFormatterFactory(cnpjDisplay);
			idFormat = new DefaultFormatterFactory(new MaskFormatter("######"), new MaskFormatter("######"), new NumberFormatter(NumberFormat.getIntegerInstance()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
