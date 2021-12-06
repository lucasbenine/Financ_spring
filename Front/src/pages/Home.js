import Navbar from '../components/Navbar/index';
import styled from 'styled-components';
import Footer from '../components/Footer/index';
import img1 from '../img/financ1.jpeg';
import img2 from '../img/financ2.jpeg';
import img3 from '../img/financ3.jpeg';
import { Link } from 'react-router-dom';

const HomeWrapper = styled.div`
  width: 100vw;
  height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
`;

const ImgDiv = styled.div`
  margin-top: 1.5%;
  width: 80%;
  display: flex;
  align-items: center;
  justify-content: space-between;

  .text-1 {
    display: flex;
    flex-flow: column nowrap;
    align-items: center;
    justify-content: space-evenly;
    width: 40%;
    text-align: center;
  }

  .title {
    font-size: 2rem;
    margin-bottom: 1rem;
  }

  .description {
    font-size: 1.4rem;
  }

  .img-home {
    width: 45%;
    height: auto;
  }

  a {
    margin-top: 1rem;
    width: 50%;
    text-decoration: none;
  }

  .button-to-cadastro {
    width: 100%;
    background-color: white;
    color: #04660E;
    padding: .6rem;
    outline: none;
    border: 2px solid #04660E;
    font-size: 1.2rem;
    border-radius: 10px;
    transition: .5s;
  }

  .button-to-cadastro:hover {
    background-color: #04660E;
    color: white;
    border: 2px solid white;
  }
`;

function Home() {
  return (
    <>
      <Navbar />
    </>
  );
}

export default Home;
