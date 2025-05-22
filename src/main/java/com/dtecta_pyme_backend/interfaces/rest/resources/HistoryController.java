package com.dtecta_pyme_backend.interfaces.rest.resources;

import com.dtecta_pyme_backend.domain.model.entities.Accountant;
import com.dtecta_pyme_backend.domain.model.entities.History;
import com.dtecta_pyme_backend.domain.services.AccountantService;
import com.dtecta_pyme_backend.domain.services.HistoryService;
import com.dtecta_pyme_backend.interfaces.rest.resources.accountant.AccountantResource;
import com.dtecta_pyme_backend.interfaces.rest.resources.accountant.CreateAccountantResource;
import com.dtecta_pyme_backend.interfaces.rest.resources.accountant.UpdateAccountantResource;
import com.dtecta_pyme_backend.interfaces.rest.resources.history.CreateHistoryResource;
import com.dtecta_pyme_backend.interfaces.rest.resources.history.HistoryResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
@RestController
@RequestMapping(value = "/api/v1/history", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "History", description = "History Management Endpoints")
public class HistoryController {

    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping()
    ResponseEntity<List<HistoryResource>> getAllHistories() {
        List<HistoryResource> historyResources = historyService.getAll()
                .stream().map(this::mapEntityToResource)
                .toList();

        return new ResponseEntity<>(historyResources, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<HistoryResource> createAccountant(@RequestBody CreateHistoryResource resource) {
        History history = historyService.create(resource);

        return new ResponseEntity<>(mapEntityToResource(history), HttpStatus.CREATED);
    }

    private HistoryResource mapEntityToResource(History history) {
        return new HistoryResource(history.getId(), history.getName(), history.getReport(), history.getDate());
    }
}
