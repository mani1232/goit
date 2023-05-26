package ua.mani123.module10;

import com.electronwill.nightconfig.core.Config;
import com.electronwill.nightconfig.core.conversion.ObjectConverter;
import com.electronwill.nightconfig.core.file.FileConfig;
import lombok.Getter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@Getter
public class FileUtils {

    Pattern numberPattern = Pattern.compile("\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}");
    File file;
    JsonDB jsonDB = new JsonDB();
    ArrayList<Map.Entry<String, AtomicInteger>> list;

    public FileUtils(String filename) {
        URL url = this.getClass().getClassLoader().getResource(filename);
        if (url != null) {
            this.file = new File(url.getFile());
        } else {
            String[] file = filename.split("\\.");
            try {
                this.file = File.createTempFile(file[0], file[1]);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public FileUtils loadNumbers(boolean print) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
            Stream<String> numbers = reader.lines().filter(s -> s.startsWith("number")).flatMap(s -> numberPattern.matcher(s).results()).map(MatchResult::group);
            if (print) numbers.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public FileUtils loadUsers(boolean print, String outFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
            reader.lines().filter(s -> s.startsWith("user")).forEach(line -> {
                String[] tokens = line.split(" ");
                String name = tokens[1];
                String age = tokens[2];

                User user = new User();
                user.setAge(age);
                user.setName(name);
                jsonDB.users.add(user);
                if (print) System.out.println(name + "-" + age);
            });
            if (!outFile.isEmpty()) {
                File outfile = new File(outFile);
                outfile.createNewFile();
                Config config = FileConfig.builder(outFile).autosave().build();
                ObjectConverter converter = new ObjectConverter();
                converter.toConfig(jsonDB, config);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    protected static class JsonDB {
        final ArrayList<User> users = new ArrayList<>();
    }

    public FileUtils countWords(boolean print) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
            Map<String, AtomicInteger> map = new HashMap<>();
            reader.lines().forEach(s -> Arrays.stream(s.split(" ")).forEach(word -> {
                    if (!map.containsKey(word)) {
                        map.put(word, new AtomicInteger(1));
                    } else {
                        map.get(word).addAndGet(1);
                    }
            }));
            if (print) System.out.println(map);
            list = new ArrayList<>(map.entrySet());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public FileUtils sort(boolean print) {
        list.sort(Map.Entry.comparingByValue(Comparator.comparing(AtomicInteger::get).reversed()));
        if (print) System.out.println(list);
        return this;
    }

}
