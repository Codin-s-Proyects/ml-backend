package com.dtecta_pyme_backend.internal;

import com.dtecta_pyme_backend.domain.model.entities.Accountant;
import com.dtecta_pyme_backend.domain.model.entities.History;
import com.dtecta_pyme_backend.domain.services.AccountantService;
import com.dtecta_pyme_backend.domain.services.HistoryService;
import com.dtecta_pyme_backend.interfaces.rest.resources.accountant.CreateAccountantResource;
import com.dtecta_pyme_backend.interfaces.rest.resources.accountant.UpdateAccountantResource;
import com.dtecta_pyme_backend.interfaces.rest.resources.history.CreateHistoryResource;
import com.dtecta_pyme_backend.repositories.AccountantRepository;
import com.dtecta_pyme_backend.repositories.HistoryRepository;
import com.dtecta_pyme_backend.shared.domain.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository historyRepository;

    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public List<History> getAll() {
        return historyRepository.findAll();
    }

    @Override
    public History create(CreateHistoryResource resource) {
        var newAccountant = new History(resource);
        return historyRepository.save(newAccountant);
    }
}
