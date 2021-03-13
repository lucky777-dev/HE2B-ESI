<Qucs Schematic 0.0.20>
<Properties>
  <View=0,0,977,800,1,0,0>
  <Grid=10,10,1>
  <DataSet=labo2R2.dat>
  <DataDisplay=labo2R2.dpl>
  <OpenDisplay=1>
  <Script=labo2R2.m>
  <RunScript=0>
  <showFrame=0>
  <FrameText0=Titre>
  <FrameText1=Auteur :>
  <FrameText2=Date :>
  <FrameText3=Version :>
</Properties>
<Symbol>
</Symbol>
<Components>
  <GND * 5 440 310 0 0 0 0>
  <R R1 1 490 130 -26 15 0 0 "1 kOhm" 1 "26.85" 0 "0.0" 0 "0.0" 0 "26.85" 0 "US" 0>
  <.DC DC1 1 80 370 0 63 0 0 "26.85" 0 "0.001" 0 "1 pA" 0 "1 uV" 0 "no" 0 "150" 0 "no" 0 "none" 0 "CroutLU" 0>
  <Vdc V1 1 310 240 18 -26 0 1 "V1" 1>
  <IProbe AmpereMetre 1 370 130 -26 16 0 0>
  <.SW SW1 1 540 370 0 63 0 0 "DC1" 1 "lin" 1 "V1" 1 "-10 V" 1 "10 V" 1 "21" 1>
  <VProbe VoltMetreR2 1 700 120 28 -31 0 0>
  <R R2 1 580 240 15 -26 0 1 "2.2 kOhm" 1 "26.85" 0 "0.0" 0 "0.0" 0 "26.85" 0 "US" 0>
</Components>
<Wires>
  <310 130 310 210 "" 0 0 0 "">
  <310 130 340 130 "" 0 0 0 "">
  <400 130 460 130 "" 0 0 0 "">
  <520 130 580 130 "" 0 0 0 "">
  <310 310 440 310 "" 0 0 0 "">
  <310 270 310 310 "" 0 0 0 "">
  <440 310 580 310 "" 0 0 0 "">
  <580 130 580 180 "" 0 0 0 "">
  <580 270 580 280 "" 0 0 0 "">
  <580 280 580 310 "" 0 0 0 "">
  <580 280 710 280 "" 0 0 0 "">
  <710 140 710 280 "" 0 0 0 "">
  <580 180 580 210 "" 0 0 0 "">
  <580 180 690 180 "" 0 0 0 "">
  <690 140 690 180 "" 0 0 0 "">
</Wires>
<Diagrams>
</Diagrams>
<Paintings>
</Paintings>
