package com.study.train.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constants {
    public static final List<Map<String, String>> CITIES = new ArrayList<Map<String, String>>() {{
        add(new HashMap<String, String>() {{
            put("id", "moscow");
            put("city", "Москва");
        }});
        add(new HashMap<String, String>() {{
            put("id", "st-petersburg");
            put("city", "Санкт-петербург");
        }});
        add(new HashMap<String, String>() {{
            put("id", "kazan");
            put("city", "Казань");
        }});
        add(new HashMap<String, String>() {{
            put("id", "rostov");
            put("city", "Ростов");
        }});
        add(new HashMap<String, String>() {{
            put("id", "tver");
            put("city", "Тверь");
        }});
        add(new HashMap<String, String>() {{
            put("id", "sochi");
            put("city", "Сочи");
        }});
        add(new HashMap<String, String>() {{
            put("id", "omsk");
            put("city", "Омск");
        }});
    }};
}
