package com.passinfracom.sentimentAnalyzer.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.passinfracom.sentimentAnalyzer.core.command.ICommand;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations.SentimentAnnotatedTree;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

public class StandfordSentimentAnalyzerImpl implements SentimentAnalyzer {

	StanfordCoreNLP pipeline;

	@Override
	public void setup() {
		Properties props = new Properties();
		props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
		pipeline = new StanfordCoreNLP(props);

	}

	@Override
	public Map<String, String> anlyzeSentiment(ICommand command) {

		Map<String, String> sentimentMap = new HashMap<String, String>();
		int mainSentiment = 0;
		String sentimentType = "NULL";
		String tweet = command.getMap().get("Tweet");
		if (tweet != null && tweet.length() > 0) {
			int longest = 0;
			Annotation annotation = pipeline.process(tweet);
			for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
				Tree tree = sentence.get(SentimentAnnotatedTree.class);
				int sentiment = RNNCoreAnnotations.getPredictedClass(tree);
				sentimentType = sentence.get(SentimentCoreAnnotations.SentimentClass.class);
			}
		}

		sentimentMap.put("Tweet", tweet);
		sentimentMap.put("SentimantType", sentimentType);

		return sentimentMap;
	}

}
