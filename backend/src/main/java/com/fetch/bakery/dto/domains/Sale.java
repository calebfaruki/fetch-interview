package com.fetch.bakery.dto.domains;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "sale", schema = "public")
@NoArgsConstructor
@Data
public class Sale implements Serializable {

    @Id
    Integer id;
    Integer treatId;

    Integer count;
    Double price;
    String time;

    Boolean repeat;
}
