import { render, screen, fireEvent } from '@testing-library/react';
import "@testing-library/jest-dom/extend-expect";
import { BrowserRouter } from 'react-router-dom';

import Despesa from '../Despesas';

const MockDespesa = () => {
    return(
        <BrowserRouter>
            <Despesa />
        </BrowserRouter>
    )
}

test("Deve chamar o evento", () => {
    const onClick = jest.fn()

    render(<MockDespesa />);

    const btn = screen.getByTestId('button-test');

    expect(btn).toBeInTheDocument();
})