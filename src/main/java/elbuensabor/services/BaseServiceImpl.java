package elbuensabor.services;

import elbuensabor.entities.Base;
import elbuensabor.repositories.BaseRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;


public abstract class BaseServiceImpl<E extends Base, ID extends Serializable> implements BaseService<E, ID> {
    protected BaseRepository<E,ID> baseRepository;

    public BaseServiceImpl(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }
}
