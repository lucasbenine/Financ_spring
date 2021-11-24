// import { render, screen, fireEvent } from "@testing-library/react";
// import "@testing-library/jest-dom/extend-expect";
// import { BrowserRouter } from "react-router-dom";
// import axios from "axios"
// import Modal from './';

// const mockDespesa = {
//     nome: "Teste",
//     preco: 25.5,
//     data: 2020-12-25,
//     descricao: "fefeeefefe"
// }

// const MockCreateDespesa = () => {
//     return (
//         <BrowserRouter>
//             <Modal />
//         </BrowserRouter>
//     );
// };

// test("Deve chamar a API", async () => {
//     axios.post.mockImplementation(() => Promise.resolve(mockDespesa));
//     render(<MockCreateDespesa />);

//     const nomeElement = screen.getByPlaceholderText("Titulo");
//     const precoElement = screen.getByPlaceholderText("Preço");
//     const dataElement = screen.getByPlaceholderText("Data");
//     const descricaoElement = screen.getByPlaceholderText("Descrição");

//     expect(nomeElement).toBeInTheDocument();
//     expect(precoElement).toBeInTheDocument();
//     expect(dataElement).toBeInTheDocument();
//     expect(descricaoElement).toBeInTheDocument();
// })
