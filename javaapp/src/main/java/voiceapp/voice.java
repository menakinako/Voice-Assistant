package voiceapp;

import java.io.IOException;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class voice {

	public static void main(String[] st) {
		
		Configuration config = new Configuration();
		
		config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		config.setDictionaryPath("src\\main\\resources\\3516.dic");
		config.setLanguageModelPath("src\\main\\resources\\3516.lm");
		
		try {
			LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config);
			speech.startRecognition(true);
			
			SpeechResult speechResult = null;
			
			while ((speechResult = speech.getResult()) != null) {
				String voiceCommand = speechResult.getHypothesis();
				System.out.println("Voice Command is " + voiceCommand);
				
				if (voiceCommand.equalsIgnoreCase("Open Chrome")) {
					Runtime.getRuntime().exec("cmd.exe /c start chrome");
				} else if (voiceCommand.equalsIgnoreCase("Close Chrome")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");
				}
                 else  if (voiceCommand.equalsIgnoreCase("Open Microsoft Edge")) {
					Runtime.getRuntime().exec("cmd.exe /c start microsoft-edge:");
				} else if (voiceCommand.equalsIgnoreCase("Close Microsoft Edge")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM MicrosoftEdge.exe");
				}
                else  if (voiceCommand.equalsIgnoreCase("Open Mozilla Firefox")) {
					Runtime.getRuntime().exec("cmd.exe /c start firefox");
                }
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
