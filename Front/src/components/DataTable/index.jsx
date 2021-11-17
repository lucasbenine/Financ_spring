import React, { useEffect, useState } from 'react';
import api from "../../api";
import { DespesaPage } from "../../types/despesa";
import { formatLocalDate } from '../../utils/format';
import styled from 'styled-components';
import { MdModeEdit, MdDelete } from "react-icons/md";
api.defaults.headers.common = {'Authorization': 'Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmZXJuYW5kbyIsImV4cCI6MTYzNzEwNzczOH0.h8xVihIZLPF1aq1SW3Jcyvc0S0llweYSmm540aYKDVxndr1D_7xW-i_TnZplsQAF0fM628TredMaYq36BiX8jA'};

const Table = styled.table`

    width: 100%;
    box-shadow: 0 1px 4px 0 rgba(0,0,0,.4);
    border-spacing: 0 1px;
    text-align: left;
    border-radius: 10px;
    margin-bottom: 30px;

    th:first-child {
        border-top-left-radius: 10px;
    }

    th:last-child {
        border-top-right-radius: 10px;
    }

    tr:last-child td:first-child {
        border-bottom-left-radius: 10px;
    }

    tr:last-child td:last-child {
        border-bottom-right-radius: 10px;
    }

    th, td {
        padding: 20px 15px;
        background: #FFFFFF;
    }
    
    tbody tr {
        opacity: 0.8;

        &:hover {
            opacity: 1;
        }
    }
    
    td.preco {
        color: red;
    }
`;

const DataTable = () => {

    // const [page, setPage] = useState<DespesaPage>({
    //     first: true,
    //     last: true,
    //     number: 0,
    //     totalElements: 0,
    //     totalPages: 0
    // });
    const [despesa, setDespesa] = useState([]);

    useEffect(() => {

        const token = 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmZXJuYW5kbyIsImV4cCI6MTYzNzE1NTg2Mn0.MY4s7XXj_1v4zs0ku_oyWqomBMPtUXGPt8Z3MqZM4DJH_TL3HPxgCjxCCLmyoXMzwWe8LG42qH_gPNnDJArrFQ';

        const config = {
            headers: {
                'Authorization': `Bearer ${token}`
            }
        };

        async function buscarDespesas() {
            const response = await api.get('despesas/user', config);
            console.log(response);
            setDespesa(response.data);
        
        }

        buscarDespesas();

    }, [])

    return (
        <>
            <Table>
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Preço</th>
                        <th>Categoria</th>
                        <th>Data</th>
                        <th>Descrição</th>
                        <th style={{width: '50px'}}>Editar</th>
                        <th style={{width: '85px'}}>Apagar</th>
                    </tr>
                </thead>
                <tbody>
                    {despesa?.map((item) => (
                        <tr key={item.id}>
                            <td>{item.nome}</td>
                            <td className="preco">R$ {item.preco.toFixed(2)}</td>
                            <td>{item.categoria.nomeCategoria}</td>
                            <td>{formatLocalDate(item.data, "dd/MM/yyyy")}</td>
                            <td>{item.descricao}</td>
                            <td style={{height: '100%', display:'flex', justifyContent:'center'}}><MdModeEdit /></td>
                            <td><MdDelete /></td>
                        </tr>
                    ))}
                </tbody>
            </Table>
        </>
    );
}

export default DataTable;