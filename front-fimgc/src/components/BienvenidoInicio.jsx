import React, { useContext, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import {
  Container,
  Image,
  Card,
  Col,
  Row,
  Table,
  Modal,
  Form,
  Button,
  InputGroup,
  NavDropdown,
  Carousel,
} from "react-bootstrap";
import Header from "./shared/Header";
import Footer from "./shared/Footer";
import AuthContext from "../Context/AuthProvider";

const BienvenidoInicio = () => {
  const navigate = useNavigate();
  const { user } = useContext(AuthContext);
  const redirectParams = (route) => {
    navigate(route);
  };

  //Para el modal
  const [modalConsulta, setModalConsulta] = useState(false);
  const handleOcultar = () => setModalConsulta(false);
  const handleMostrar = () => setModalConsulta(true);

  return (
    <div>
      <Header />
      <Container className="container-bienvenido-titulo">
        <Carousel slide indicators={false} controls={false}>
          <Carousel.Item>
            <img src="/banner-escuelas.png" />
          </Carousel.Item>
          <Carousel.Item>
            <img src="/banner-escuelas.png" />
          </Carousel.Item>
        </Carousel>
        <Row xs={2} md={3} lg={6} className="g-4 row-cards-customize">
          <Col>
            <Card
              className={`customize-card-2 ${
                user.role == 1 || user.role == 2 || user.role == 6? "active" : "inactive"
              }`}
              onClick={() => {
                if (user.role == 1 || user.role == 2) {
                  redirectParams("/tramites");
                }
              }}
            >
              <Card.Img variant="top" src="/r1.png" />
              <Card.Body>
                <p className="card-title-customize">Realizar trámite</p>
              </Card.Body>
            </Card>
          </Col>
          <Col>
            <Card
              className={`customize-card-2 ${
                user.role == 1 ||
                user.role == 2 ||
                user.role == 3 ||
                user.role == 4 ||
                user.role == 5 ||
                user.role == 6
                  ? "active"
                  : "inactive"
              }`}
              onClick={handleMostrar}
            >
              <Card.Img variant="top" src="/r2.png" />
              <Card.Body>
                <p className="card-title-customize">Consultar trámite</p>
              </Card.Body>
            </Card>
          </Col>

          <Col>
            <Card
              className={`customize-card-2 ${
                user.role == 1 ||
                user.role == 3 ||
                user.role == 4 ||
                user.role == 5
                  ? "active"
                  : "inactive"
              }`}
            >
              <Card.Img
                variant="top"
                src="/r6.png"
                alt="Files and folders icons created by Freepik - Flaticon"
              />
              <Card.Body>
                <NavDropdown
                  className="card-title-customize"
                  id="nav-dropdown-dark-example"
                  title="Enviar"
                >
                  <NavDropdown.Item
                    className="cardlink"
                    drop="up-centered"
                    onClick={() => {
                      if (user.role == 4 || user.role == 1) {
                        redirectParams("/enviar-constancia");
                      }
                    }}
                  >
                    Constancia de originalidad
                  </NavDropdown.Item>
                  <NavDropdown.Divider />
                  <NavDropdown.Item
                    className="cardlink"
                    onClick={() => {
                      if (user.role == 3 || user.role == 1) {
                        redirectParams("/enviar-dictamen");
                      }
                    }}
                    
                  >
                    Dictamen
                  </NavDropdown.Item>
                  <NavDropdown.Divider />
                  <NavDropdown.Item
                    className="cardlink"
                    onClick={() => {
                      if (user.role == 5 || user.role == 1) {
                        redirectParams("/enviar-expediente");
                      }
                    }}
                    
                  >
                    Expediente
                  </NavDropdown.Item>
                </NavDropdown>
              </Card.Body>
            </Card>
          </Col>
          <Col>
            <Card
              className={`customize-card-2 ${
                user.role == 1 ||
                user.role == 6
                  ? "active"
                  : "inactive"
              }`}
              onClick={() => {
                if (user.role == 6 || user.role == 1) {
                  redirectParams("/documentos");
                }
              }}
            >
              <Card.Img variant="top" src="/r5.png" />
              <Card.Body>
                <p className="card-title-customize">Generar documento</p>
              </Card.Body>
            </Card>
          </Col>
          <Col>
            <Card
              
              className={`customize-card-2 ${
                user.role == 1
                  ? "active"
                  : "inactive"
              }`}
              onClick={() => {
                if (user.role == 6 || user.role == 1) {
                  redirectParams("/params");
                }
              }}
            >
              <Card.Img variant="top" src="/r3.png" />
              <Card.Body>
                <p className="card-title-customize">Parámetros</p>
              </Card.Body>
            </Card>
          </Col>
          <Col>
            <Card
              className={`customize-card-2 ${
                user.role == 1 ||
                user.role == 6
                  ? "active"
                  : "inactive"
              }`}
              onClick={() => redirectParams("/bandeja")}
            >
              <Card.Img
                variant="top"
                src="/r4.png"
                alt="Bandeja de entrada iconos creados por Freepik - Flaticon"
              />
              <Card.Body>
                <p className="card-title-customize">Bandeja de expedientes</p>
              </Card.Body>
            </Card>
          </Col>
              
        </Row>
      </Container>

      <Modal
        aria-labelledby="modal-consultar-tramite"
        size="lg"
        show={modalConsulta}
        centered
      >
        <Modal.Header closeButton onHide={handleOcultar}>
          <Modal.Title className="title-modal1">Consultar trámite</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form>
            <Form.Group>
              <InputGroup>
                <Form.Control
                  type="search"
                  placeholder="Ingrese el número de expediente."
                  aria-label="Ingrese el número de expediente."
                />
                <Button variant="outline-dark">
                  <i className="fi fi-bs-search-alt"></i> Buscar expediente
                </Button>
              </InputGroup>
            </Form.Group>
          </Form>
          <Table responsive="sm">
            <thead className="thead-text-customize">
              <tr>
                <th>Nº de expediente</th>
                <th>Nombre</th>
                <th>Tipo de trámite</th>
                <th>Dependencia</th>
                <th>Estado</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>Nº de expediente</td>
                <td>Nombre</td>
                <td>Tipo de trámite</td>
                <td>Dependencia</td>
                <td>
                  En proceso |{" "}
                  <Link to={"/expediente-observado/id"}>Observado</Link>
                </td>
              </tr>
            </tbody>
          </Table>
        </Modal.Body>
      </Modal>
      <Footer />
    </div>
  );
};

export default BienvenidoInicio;
