package it.bz.opendatahub.webcomponents.dataservice.controller;

import it.bz.opendatahub.webcomponents.common.data.rest.Webcomponent;
import it.bz.opendatahub.webcomponents.common.data.rest.WebcomponentEntry;
import it.bz.opendatahub.webcomponents.dataservice.converter.impl.WebcomponentConverter;
import it.bz.opendatahub.webcomponents.dataservice.converter.impl.WebcomponentEntryConverter;
import it.bz.opendatahub.webcomponents.dataservice.data.dto.WebcomponentDto;
import it.bz.opendatahub.webcomponents.dataservice.service.WebcomponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/webcomponent")
public class WebcomponentController {
    private WebcomponentService webcomponentService;
    private WebcomponentEntryConverter webcomponentEntryConverter;
    private WebcomponentConverter webcomponentConverter;

    @Autowired
    public WebcomponentController(WebcomponentService webcomponentService,
                                  WebcomponentEntryConverter webcomponentEntryConverter,
                                  WebcomponentConverter webcomponentConverter) {

        this.webcomponentService = webcomponentService;
        this.webcomponentEntryConverter = webcomponentEntryConverter;
        this.webcomponentConverter = webcomponentConverter;
    }

    @GetMapping
    public ResponseEntity<Page<WebcomponentEntry>> find(
                                                           @RequestParam(name = "tags", required = false) String[] tags,
                                                           @RequestParam(name = "term", required = false, defaultValue = "") String term,
                                                           Pageable pageRequest
                                                           ) {

        List<String> tagList = Collections.emptyList();
        if(tags != null) {
            tagList = Arrays.asList(tags);
        }

        Page<WebcomponentDto> resultPage = webcomponentService.listAll(pageRequest, tagList, term);

        return new ResponseEntity<>(new PageImpl(webcomponentEntryConverter.dtoToRest(resultPage.getContent()), pageRequest, resultPage.getTotalElements()), HttpStatus.OK);
    }

    @GetMapping("/detail/{uuid}")
    public ResponseEntity<Webcomponent> getOne(@PathVariable String uuid) {
        return new ResponseEntity<>(webcomponentConverter.dtoToRest(webcomponentService.findOne(uuid)), HttpStatus.OK);
    }
}
