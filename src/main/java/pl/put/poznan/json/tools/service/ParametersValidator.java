package pl.put.poznan.json.tools.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
public class ParametersValidator {

    public void validate(String json, String[] attributes, String attributesMode, String whiteSpaces) throws WrongInputException {
        validateAttributtes(attributes, attributesMode);
        validateWhiteSpaces(whiteSpaces);
        validateJson(json);
    }

    private void validateAttributtes(String[] attributes, String attributesMode) throws WrongInputException {
        if ((attributesMode != null) && (!attributesMode.equals("delete")) && (!attributesMode.equals("pick"))){
            throw new WrongInputException("Wrong value of attributeMode parameter");
        }
    }

    private void validateWhiteSpaces(String whiteSpaces) throws WrongInputException {
        if ((whiteSpaces != null) && (!whiteSpaces.equals("delete")) && (!whiteSpaces.equals("add"))){
            throw new WrongInputException("Wrong value of whiteSpace parameter");
        }
    }

    private void validateJson(String json) throws WrongInputException {
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(json);
        } catch (ParseException e) {
            throw new WrongInputException("Wrong JSON input");
        }
    }
}
