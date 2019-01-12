package es.jaolve.QCHParserM.paraules;

import java.util.Locale;

import org.simmetrics.SetMetric;
import org.simmetrics.StringDistance;
import org.simmetrics.StringMetric;
import org.simmetrics.builders.StringDistanceBuilder;
import org.simmetrics.builders.StringMetricBuilder;
import org.simmetrics.metrics.CosineSimilarity;
import org.simmetrics.metrics.Levenshtein;
import org.simmetrics.metrics.OverlapCoefficient;
import org.simmetrics.metrics.StringMetrics;
import org.simmetrics.simplifiers.Simplifier;
import org.simmetrics.simplifiers.Simplifiers;
import org.simmetrics.tokenizers.Tokenizers;

import es.jaolve.QCHParserM.cor.paraules.TextUtils;

public class ParaulesPercentatgeCoincidencia {

	public static void main(String[] args) {
		
	  final String x = "Dani Miquel";
	  final String a1 = "Dani   Miquel";
	  final String a2 = "Dani Miquel i los ma me mi mo mu";
	  final String a3 = "D. Miquel";
	  final String a4 = "Miquel GIL";
	  final String a5 = "ani quel";

	  int per1 = TextUtils.pecentageOfTextMatch(x, a1);
	  int per2 = TextUtils.pecentageOfTextMatch(x, a2);
	  int per3 = TextUtils.pecentageOfTextMatch(x, a3);
	  int per4 = TextUtils.pecentageOfTextMatch(x, a4);
	  int per5 = TextUtils.pecentageOfTextMatch(x, a5);
	  
	  int c1 = TextUtils.commonWords (x, a1).length;
	  int c2 = TextUtils.commonWords(x, a2).length;
	  int c3 = TextUtils.commonWords(x, a3).length;
	  int c4 = TextUtils.commonWords(x, a4).length;
	  int c5 = TextUtils.commonWords(x, a5).length;
	  
	 // StringMetric metric =
				
	  StringMetric metric1 = StringMetricBuilder
				.with(new CosineSimilarity<String>())
				.simplify(Simplifiers.toLowerCase(Locale.ENGLISH))
				.simplify(Simplifiers.replaceNonWord())
				.tokenize(Tokenizers.whitespace()).build();
		
	  float simetricCousin1 = metric1.compare(x, a1);
	  float simetricCousin2 = metric1.compare(x, a2);
	  float simetricCousin3 = metric1.compare(x, a3);
	  float simetricCousin4 = metric1.compare(x, a4);
	  float simetricCousin5 = metric1.compare(x, a5);
	  
	  /*SetMetric<String> metric2 = new OverlapCoefficient();
	  float overlap1 = metric2.compare(x, a1);
	  float overlap2 = metric2.compare(x, a2);
	  float overlap3 = metric2.compare(x, a3);
	  float overlap4 = metric2.compare(x, a4);
	  float overlap5 = metric2.compare(x, a5);*/
	  
	  StringDistance metric = StringDistanceBuilder.
			  with(new Levenshtein())
				.simplify(Simplifiers.toLowerCase())
				.simplify(Simplifiers.removeDiacritics())
				.build();

	  float d1 = metric.distance(x, a1);
	  float d2 = metric.distance(x, a2); 
	  float d3 = metric.distance(x, a3); 
	  float d4 = metric.distance(x, a4); 
	  float d5 = metric.distance(x, a5); 

	  System.out.println ("Percentatge: ");
	  System.out.println (per1 +"-" +c1+"/" +a1.split("[^a-z]+").length+" - "+simetricCousin1+" - "+d1);
	  System.out.println (per2 +"-" +c2+"/" +a2.split("[^a-z]+").length+" - "+simetricCousin2+" - "+d2);
	  System.out.println (per3 +"-" +c3+"/" +a3.split("[^a-z]+").length+" - "+simetricCousin3+" - "+d3);
	  System.out.println (per4 +"-" +c4+"/" +a4.split("[^a-z]+").length+" - "+simetricCousin4+" - "+d4);
	  System.out.println (per5 +"-" +c5+"/" +a5.split("[^a-z]+").length+" - "+simetricCousin5+" - "+d5);



	}



}
