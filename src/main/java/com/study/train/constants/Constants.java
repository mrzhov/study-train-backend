package com.study.train.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constants {
    public static final List<Map<String, String>> CITIES = new ArrayList<Map<String, String>>() {{
        add(new HashMap<String, String>() {{
            put("id", "moscow");
            put("name", "Москва");
        }});
        add(new HashMap<String, String>() {{
            put("id", "st-petersburg");
            put("name", "Санкт-петербург");
        }});
        add(new HashMap<String, String>() {{
            put("id", "kazan");
            put("name", "Казань");
        }});
        add(new HashMap<String, String>() {{
            put("id", "rostov");
            put("name", "Ростов");
        }});
        add(new HashMap<String, String>() {{
            put("id", "tver");
            put("name", "Тверь");
        }});
        add(new HashMap<String, String>() {{
            put("id", "sochi");
            put("name", "Сочи");
        }});
        add(new HashMap<String, String>() {{
            put("id", "omsk");
            put("name", "Омск");
        }});
    }};
}
