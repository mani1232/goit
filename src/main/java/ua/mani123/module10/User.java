package ua.mani123.module10;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable {
    String name;
    String age;
}
