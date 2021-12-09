import styles from '../Contas.css'
import {useState, useEffect} from 'react'
import api from '../api';
import ModalContas from '../components/ModalContas';

function ContasAPagar(){

    const [contasAPagar, setContasAPagar] = useState([]);
    const [showModal, setShowModal] = useState(false);
    const closeModal = () => setShowModal(false);

    useEffect (() => {
        async function buscarContas(){
            await api.get("contasapagar")
                .then(res => {
                    console.log(res.data)
                    setContasAPagar(res.data)
                })
        }

        buscarContas();
    },[])

    return(
        <div>
            <div className="two_divs">
                <div className="balanco_mensal">
                    <h1>Balanço mensal - Contas Fixas:</h1>
                    <h2>Gráfico</h2>
                </div>
                <div className="relatorio_contas">
                    <button className="green">Relatório de Contas</button>
                    <button className="green" onClick={() => setShowModal(true)}>Adicionar Saída</button>
                    <button className="green">Editar Saída</button>
                    <button className="green">Remover Saída</button>
                </div>
            </div>    
                <div className="lancamentos">
                    <div className="border_one">
                        <h1>Contas A Pagar</h1>
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
                                {contasAPagar?.map((item) => (
                                    <tr key={item.id}>
                                        <td>{item.nomeConta}</td>
                                        <td>{item.valorConta}</td>
                                        <td>{item.categoria}</td>
                                    </tr>
                                ))}    
                            </tbody>  
                    </table>
               </div>
               <ModalContas show={showModal} close={closeModal}/>  
        </div> 
    )
}

export default ContasAPagar