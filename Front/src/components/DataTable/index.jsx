import React, { useEffect, useState } from 'react';
import api from "../../api";
import { formatLocalDate } from '../../utils/format';
import { MdModeEdit, MdDelete, MdClose } from "react-icons/md";
import axios from 'axios';
import * as C from './styles';
import ModalEdit from '../ModalEdit';

// const TableHeader = styled.div`

//     width: 100%;
//     display: flex;
//     justify-content: space-between;
//     align-items: center;
//     padding: 20px;
//     background-color: #FFF;


//     button {
//         padding: 15px 20px;
//         background: #ff7e7c;
//         border: none;
//         color: #FFF;
//         border-radius: 10px;
//         font-weight: 600;
//         cursor: pointer;
//     }
// `;


const DataTable = ({mes, ano}) => {

    // const [page, setPage] = useState<DespesaPage>({
    //     first: true,
    //     last: true,
    //     number: 0,
    //     totalElements: 0,
    //     totalPages: 0
    // });
    console.log('Mes e ano atual' + mes)
    const [despesa, setDespesa] = useState([]);

    const token = localStorage.getItem('token')
    const config = {
        headers: {
            'Authorization': `Bearer ${token}`
        }
    };

    const [mesA, setMesA] = useState(12)

    if(mes !== mesA) {
        async function buscarDespesas() {
            const response = await api.get(`despesas/month/${mes+1}/${ano}`, config);
            console.log(response);
            setDespesa(response.data);
            setMesA(mes)
        
        }

        buscarDespesas();
    }

    // useEffect(() => {

    //     async function buscarDespesas() {
    //         const response = await api.get(`despesas/month/${mes+1}/${ano}`, config);
    //         console.log(response);
    //         setDespesa(response.data);
        
    //     }

    //     buscarDespesas();

    // }, [])


    const [show, setShow] = useState(false);
    const close = () => setShow(false);

    const [despesaAtual, setDespesaAtual] = useState([]);

    function handleTeste(item) {
        setShow(true);
        setDespesaAtual(item);
    }

    const [showModalConfirm, setShowModalConfirm] = useState(false);
    const closeModalConfirm = () => setShowModalConfirm(false);

    function apagarDespesa() {
        axios.delete(`http://localhost:8080/despesas/${despesaAtual.id}`, config)
            .then(window.location.reload())
        
    }

    const [showModalEdit, setShowModalEdit] = useState(false)
    const closeModalEdit = () => setShowModalEdit(false)


    return (
        <>
            {/* <TableHeader>
                <h2>Despesas</h2>
                <span>Novembro 2021</span>
                <button>Cadastrar Despesa</button>
            </TableHeader> */}
            <C.Table data-testid="table-test">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th style={{textAlign:'center'}}>Categoria</th>
                        <th style={{textAlign:'end'}}>Preço</th>
                        {/* <th>Data</th>
                        <th>Descrição</th>
                        <th style={{width: '50px'}}>Editar</th>
                        <th style={{width: '85px'}}>Apagar</th> */}
                    </tr>
                </thead>
                <tbody>
                    {despesa?.map((item) => (
                        <tr key={item.id} onClick={() => handleTeste(item)}>
                            <td>{item.nome}</td>
                            <td style={{textAlign:'center'}}>{item.categoria.nomeCategoria}</td>
                            <td className="despesa" style={{textAlign:'end'}}>R$ {item.preco.toFixed(2)}</td>
                            {/* <td>{formatLocalDate(item.data, "dd/MM/yyyy")}</td> */}
                            {/* <td>{item.descricao}</td> */}
                            {/* <td style={{height: '100%', display:'flex', justifyContent:'center'}}><MdModeEdit /></td>
                            <td><MdDelete /></td> */}
                        </tr>
                    ))}
                </tbody>
            </C.Table>

            <C.ModalDetails data-testid="modalDetails" style={{
                display: show ? 'flex' : 'none'
            }}>
                <a onClick={close}><MdClose /></a>
                <div id="modalContainer">
                    <div id="container">
                        <div>
                            <h3>{despesaAtual.nome}</h3>
                            <p className="despesa">R$ {despesaAtual.preco}</p>
                        </div>
                        <div>
                            <div className="details">
                                <span>Data</span>
                                <p>{despesaAtual.data}</p>
                            </div>
                            <div className="details">
                                <span>Categoria</span>
                                {/* <p>{despesaAtual.categoria.nomeCategoria}</p> */}
                            </div>
                            <div className="details">
                                <span>Descrição</span>
                                <p>{despesaAtual.descricao}</p>
                            </div>
                        </div>
                        <div>
                            <button onClick={() => setShowModalEdit(true)} ><MdModeEdit /> Editar</button>
                            <button onClick={() => setShowModalConfirm(true)} id="excluir" ><MdDelete /> Excluir</button>
                        </div>
                    </div>
                </div> 
                <div className="wrapper"></div>
            </C.ModalDetails>

            <C.ModalConfirm style={{
                display: showModalConfirm ? 'flex' : 'none'
            }}>
                <div id="modalConfirm">
                    <div id="fechar" onClick={closeModalConfirm}>+</div>

                    <p>Você tem certeza que deseja apagar a <br /> despesa "{despesaAtual.nome}"</p>
                    <button onClick={() => apagarDespesa()}>Sim</button>
                    <button style={{background:'#aaa', marginTop:'10px'}} onClick={closeModalConfirm}>Não</button>
                </div>
                <div className="wrapper" />
            </C.ModalConfirm>
            <ModalEdit show={showModalEdit} close={closeModalEdit} despesa={despesaAtual} type="despesas" />
        </>
    );
}

export default DataTable;