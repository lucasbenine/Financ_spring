import styles from '../Contas.css'
import {useState, useEffect} from 'react'
import api from '../api';
import ModalContas from '../components/ModalContas';
import ModalContasAReceber from '../ModalContasAReceber/indexCr';
import ModalContasCrEdit from '../ModalContasAReceber/editCr';
import ModalContasDelete from '../components/ModalContas/delete';


function ContasAReceber(){

    const [contasAReceber, setContasAReceber] = useState([]);
    const [showModal, setShowModal] = useState(false);
    const closeModal = () => setShowModal(false);
    const [showModalEdit, setShowModalEdit] = useState(false);
    const closeModalEdit = () => setShowModalEdit(false);
    const [showModalDelete, setShowModalDelete] = useState(false);
    const closeModalDelete = () => setShowModalDelete(false);

    useEffect (() => {
        async function buscarContas(){
            await api.get("contasareceber")
                .then(res => {
                    console.log(res.data)
                    setContasAReceber(res.data)
                })
        }
    },[])

    return(
        <div className="main">
            <div className="two_divs">
                <div className="balanco_mensal">
                    <h1>Balanço mensal - Contas Fixas:</h1>
                </div>
                <div className="relatorio_contas">
                    <button className="green">Relatório de Recebimentos</button>
                    <button className="green" onClick={() => setShowModal(true)}>Adicionar Recebimento</button>
                    <button className="green" onClick={() => setShowModalEdit(true)}>Editar Recebimento</button>
                    <button className="green" onClick={() => setShowModalDelete(true)}>Remover Recebimento</button>
                </div>
            </div>    
            <div className="lancamentos">
                    <div className="border_one">
                        <h1>Contas A Receber</h1>
                    </div>
                    <table style={{width: "100%"}}>
                            <thead>
                                <tr>
                                    <th>Nome:</th>
                                    <th>Valor:</th>
                                    <th>Categoria:</th>
                                </tr>
                            </thead> 
                            <tbody>
                                {contasAReceber?.map((item) => (
                                    <tr>
                                        <td>{item.nomeConta}</td>
                                        <td>{item.valorConta}</td>
                                        <td>{item.categoria}</td>
                                    </tr>
                                ))}    
                            </tbody>  
                    </table>
               </div>
               <ModalContasAReceber show={showModal} close={closeModal}/> 
               <ModalContasCrEdit show={showModalEdit} close={closeModalEdit}/>
               <ModalContasDelete show={showModalDelete} close={closeModalDelete}/>
        </div> 
    )
}

export default ContasAReceber