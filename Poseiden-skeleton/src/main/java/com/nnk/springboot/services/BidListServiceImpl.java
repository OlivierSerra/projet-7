    package com.nnk.springboot.services;

    import com.nnk.springboot.domain.BidList;
    import com.nnk.springboot.repositories.BidListRepository;
    import org.springframework.stereotype.Service;

    import java.util.List;

    /**
     * classe implémentant le service BidListService pour gérer les entités - lien entre contoller et couche d'accès aux données.
     */
    @Service
    public class BidListServiceImpl implements BidListService{
        private final BidListRepository repo;

        public BidListServiceImpl(BidListRepository repo) {

            this.repo = repo;
        }

        /**
         * retourne liste complete de BidList
         * @return
         */
        @Override
        public List<BidList> findAll(){
            return repo.findAll();
        }

        /**
         *  recherche une bid List en fonctionde son ID
         * @param id
         * @return
         */
        @Override
        public BidList findById(Integer id) {
            return repo.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Bid not found " + id));
        }

        /**
         * enr une nouvelle bidList
         * @param b
         * @return
         */
        @Override
        public BidList save(BidList b){
            return repo.save(b);
        }

        /**
         * MAJ d'une bidList
         * @param id
         * @param bid
         * @return
         */
        @Override
        public BidList update(Integer id, BidList bid){
            BidList e = findById(id);
            e.setAccount(bid.getAccount());
            e.setType(bid.getType());
            e.setBidQuantity(bid.getBidQuantity());
            return repo.save(e);
        }

        /**
         * Suppr d'un bidList selon son ID
         * @param id
         */
        @Override
        public void deleteById(Integer id){
            repo.deleteById(id);
        }
    }
