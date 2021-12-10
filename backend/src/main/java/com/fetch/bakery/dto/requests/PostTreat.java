package com.fetch.bakery.dto.requests;

import com.fetch.bakery.dto.domains.Treat;
import lombok.Getter;

import java.util.List;

@Getter
public class PostTreat {

    private List<Treat> treats;
}
