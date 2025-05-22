package com.dtecta_pyme_backend.domain.services;

import com.dtecta_pyme_backend.domain.model.entities.Accountant;
import com.dtecta_pyme_backend.domain.model.entities.History;
import com.dtecta_pyme_backend.interfaces.rest.resources.accountant.CreateAccountantResource;
import com.dtecta_pyme_backend.interfaces.rest.resources.accountant.UpdateAccountantResource;
import com.dtecta_pyme_backend.interfaces.rest.resources.history.CreateHistoryResource;

import java.util.List;

public interface HistoryService {
    List<History> getAll();
    History create(CreateHistoryResource resource);
}
