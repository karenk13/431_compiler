buildList
multiple
add
recurseList
main
If: 
globals0:
define i32 @scanf(i8*  , ...  )
define i32 @printf(i8*  , ...  )
define i8* @malloc(i32  )
type %struct.node = {i32, %struct.node*};
buildList0:
define %struct.node @buildList()
%input = alloca i32
%i = alloca i32
%n0 = alloca %struct.node*
%n1 = alloca %struct.node*
%n2 = alloca %struct.node*
%n3 = alloca %struct.node*
%n4 = alloca %struct.node*
%n5 = alloca %struct.node*
buildList1:
buildList1:
%u0 = call i8* malloc(12)
%u1 = BITCAST i8* %u0 to %struct.node
%u2 = load * %n0
store %u1 %struct.node, %u2* 
%u3 = call i8* malloc(12)
%u4 = BITCAST i8* %u3 to %struct.node
%u5 = load * %n1
store %u4 %struct.node, %u5* 
%u6 = call i8* malloc(12)
%u7 = BITCAST i8* %u6 to %struct.node
%u8 = load * %n2
store %u7 %struct.node, %u8* 
%u9 = call i8* malloc(12)
%u10 = BITCAST i8* %u9 to %struct.node
%u11 = load * %n3
store %u10 %struct.node, %u11* 
%u12 = call i8* malloc(12)
%u13 = BITCAST i8* %u12 to %struct.node
%u14 = load * %n4
store %u13 %struct.node, %u14* 
%u15 = call i8* malloc(12)
%u16 = BITCAST i8* %u15 to %struct.node
%u17 = load * %n5
store %u16 %struct.node, %u17* 
%u18 = call i32 (i8*, ... )*  @scanf(i8* getelementptr inbounds ([4xi8]*@.scanf,i32 0, i32 0), i32 %_scanned)
%u19 = load i32* %_scanned
%u20 = load %struct.node* %n0
%u21 = getelementptr %struct.node* %u20, i1 0, i32 0
store %u19 i32, %u21* %struct.node
%u22 = call i32 (i8*, ... )*  @scanf(i8* getelementptr inbounds ([4xi8]*@.scanf,i32 0, i32 0), i32 %_scanned)
%u23 = load i32* %_scanned
%u24 = load %struct.node* %n1
%u25 = getelementptr %struct.node* %u24, i1 0, i32 0
store %u23 i32, %u25* %struct.node
%u26 = call i32 (i8*, ... )*  @scanf(i8* getelementptr inbounds ([4xi8]*@.scanf,i32 0, i32 0), i32 %_scanned)
%u27 = load i32* %_scanned
%u28 = load %struct.node* %n2
%u29 = getelementptr %struct.node* %u28, i1 0, i32 0
store %u27 i32, %u29* %struct.node
%u30 = call i32 (i8*, ... )*  @scanf(i8* getelementptr inbounds ([4xi8]*@.scanf,i32 0, i32 0), i32 %_scanned)
%u31 = load i32* %_scanned
%u32 = load %struct.node* %n3
%u33 = getelementptr %struct.node* %u32, i1 0, i32 0
store %u31 i32, %u33* %struct.node
%u34 = call i32 (i8*, ... )*  @scanf(i8* getelementptr inbounds ([4xi8]*@.scanf,i32 0, i32 0), i32 %_scanned)
%u35 = load i32* %_scanned
%u36 = load %struct.node* %n4
%u37 = getelementptr %struct.node* %u36, i1 0, i32 0
store %u35 i32, %u37* %struct.node
%u38 = call i32 (i8*, ... )*  @scanf(i8* getelementptr inbounds ([4xi8]*@.scanf,i32 0, i32 0), i32 %_scanned)
%u39 = load i32* %_scanned
%u40 = load %struct.node* %n5
%u41 = getelementptr %struct.node* %u40, i1 0, i32 0
store %u39 i32, %u41* %struct.node
%u42 = load %struct.node* %n1
%u43 = load %struct.node* %n0
%u44 = getelementptr %struct.node* %u43, i1 0, i32 1
store %u42 %struct.node, %u44* %struct.node
%u45 = load %struct.node* %n2
%u46 = load %struct.node* %n1
%u47 = getelementptr %struct.node* %u46, i1 0, i32 1
store %u45 %struct.node, %u47* %struct.node
%u48 = load %struct.node* %n3
%u49 = load %struct.node* %n2
%u50 = getelementptr %struct.node* %u49, i1 0, i32 1
store %u48 %struct.node, %u50* %struct.node
%u51 = load %struct.node* %n4
%u52 = load %struct.node* %n3
%u53 = getelementptr %struct.node* %u52, i1 0, i32 1
store %u51 %struct.node, %u53* %struct.node
%u54 = load %struct.node* %n5
%u55 = load %struct.node* %n4
%u56 = getelementptr %struct.node* %u55, i1 0, i32 1
store %u54 %struct.node, %u56* %struct.node
%u57 = load i1* 0
%u58 = load %struct.node* %n5
%u59 = getelementptr %struct.node* %u58, i1 0, i32 1
store %u57 i1, %u59* %struct.node
multiple0:
define i32 @multiple(%struct.node list)
%i = alloca i32
%product = alloca i32
%cur = alloca %struct.node*
multiple1:
multiple1:
%u0 = load i32* 0
%u1 = load * %i
store %u0 i32, %u1* 
%u2 = load %struct.node* %list
%u3 = load * %cur
store %u2 %struct.node, %u3* 
%u4 = load %struct.node* %cur
%u5 = getelementptr %struct.node* %u4, i1 0, i32 0
%u6 = load * %product
store %u5 %struct.node, %u6* 
%u7 = load %struct.node* %cur
%u8 = getelementptr %struct.node* %u7, i1 0, i32 1
%u9 = load * %cur
store %u8 %struct.node, %u9* 
multiple2:
%u10 = load i32* %i
%u11 = load i32* 5
%u12 = icmp SLT i32 %u10, %u11
br i1 LT, label multiple4, label multiple-1
multiple3:
multiple4:
%u13 = load i32* %product
%u14 = load %struct.node* %cur
%u15 = getelementptr %struct.node* %u14, i1 0, i32 0
%u16 = MUL i32 %u13, %u15
%u17 = load * %product
store %u16 i32, %u17* 
%u18 = load %struct.node* %cur
%u19 = getelementptr %struct.node* %u18, i1 0, i32 1
%u20 = load * %cur
store %u19 %struct.node, %u20* 
%u21 = load i32* %product
%u22 = call i32 (i8*, ... )* @printf(i8* getelementptr inbounds ([4xi8]*@.println,i32 0, i32 0), i32 %u21)
%u23 = load i32* %i
%u24 = load i32* 1
%u25 = ADD i32 %u23, %u24
%u26 = load * %i
store %u25 i32, %u26* 
br label multiple2
multiple5:
add0:
define i32 @add(%struct.node list)
%i = alloca i32
%sum = alloca i32
%cur = alloca %struct.node*
add1:
add1:
%u0 = load i32* 0
%u1 = load * %i
store %u0 i32, %u1* 
%u2 = load %struct.node* %list
%u3 = load * %cur
store %u2 %struct.node, %u3* 
%u4 = load %struct.node* %cur
%u5 = getelementptr %struct.node* %u4, i1 0, i32 0
%u6 = load * %sum
store %u5 %struct.node, %u6* 
%u7 = load %struct.node* %cur
%u8 = getelementptr %struct.node* %u7, i1 0, i32 1
%u9 = load * %cur
store %u8 %struct.node, %u9* 
add2:
%u10 = load i32* %i
%u11 = load i32* 5
%u12 = icmp SLT i32 %u10, %u11
br i1 LT, label add4, label add-1
add3:
add4:
%u13 = load i32* %sum
%u14 = load %struct.node* %cur
%u15 = getelementptr %struct.node* %u14, i1 0, i32 0
%u16 = ADD i32 %u13, %u15
%u17 = load * %sum
store %u16 i32, %u17* 
%u18 = load %struct.node* %cur
%u19 = getelementptr %struct.node* %u18, i1 0, i32 1
%u20 = load * %cur
store %u19 %struct.node, %u20* 
%u21 = load i32* %sum
%u22 = call i32 (i8*, ... )* @printf(i8* getelementptr inbounds ([4xi8]*@.println,i32 0, i32 0), i32 %u21)
%u23 = load i32* %i
%u24 = load i32* 1
%u25 = ADD i32 %u23, %u24
%u26 = load * %i
store %u25 i32, %u26* 
br label add2
add5:
recurseList0:
define i32 @recurseList(%struct.node list)
recurseList1:
recurseList1:
%u0 = load %struct.node* %list
%u1 = getelementptr %struct.node* %u0, i1 0, i32 1
%u2 = load i1* 0
%u3 = icmp EQ %struct.node %u1, %u2
br i1 EQ, label recurseList2, label recurseList4
recurseList2:
br label recurseList6
recurseList3:
recurseList4:
br label recurseList6
recurseList5:
main0:
define i32 @main()
%list = alloca %struct.node*
%product = alloca i32
%sum = alloca i32
%result = alloca i32
%bigProduct = alloca i32
%i = alloca i32
main1:
main1:
%u0 = load i32* 0
%u1 = load * %i
store %u0 i32, %u1* 
%u2 = load i32* 0
%u3 = load * %bigProduct
store %u2 i32, %u3* 
%u4 = call %struct.node %buildList()
%u5 = load * %list
store %u4 %struct.node, %u5* 
%u6 = load %struct.node* %list
%u7 = call i32 %multiple(%u6)
%u8 = load * %product
store %u7 i32, %u8* 
%u9 = load %struct.node* %list
%u10 = call i32 %add(%u9)
%u11 = load * %sum
store %u10 i32, %u11* 
%u12 = load i32* %product
%u13 = load i32* %sum
%u14 = load i32* 2
%u15 = SDIV i32 %u13, %u14
%u16 = SUB i32 %u12, %u15
%u17 = load * %result
store %u16 i32, %u17* 
main2:
%u18 = load i32* %i
%u19 = load i32* 2
%u20 = icmp SLT i32 %u18, %u19
br i1 LT, label main4, label main-1
main3:
main4:
%u21 = load i32* %bigProduct
%u22 = load %struct.node* %list
%u23 = call i32 %recurseList(%u22)
%u24 = ADD i32 %u21, %u23
%u25 = load * %bigProduct
store %u24 i32, %u25* 
%u26 = load i32* %i
%u27 = load i32* 1
%u28 = ADD i32 %u26, %u27
%u29 = load * %i
store %u28 i32, %u29* 
br label main2
main5:
%u30 = load i32* %bigProduct
%u31 = call i32 (i8*, ... )* @printf(i8* getelementptr inbounds ([4xi8]*@.println,i32 0, i32 0), i32 %u30)
main6:
%u32 = load i32* %bigProduct
%u33 = load i32* 0
%u34 = icmp NE i32 %u32, %u33
br i1 NE, label main8, label main-1
main7:
main8:
%u35 = load i32* %bigProduct
%u36 = load i32* 1
%u37 = SUB i32 %u35, %u36
%u38 = load * %bigProduct
store %u37 i32, %u38* 
br label main6
main9:
%u39 = load i32* %result
%u40 = call i32 (i8*, ... )* @printf(i8* getelementptr inbounds ([4xi8]*@.println,i32 0, i32 0), i32 %u39)
%u41 = load i32* %bigProduct
%u42 = call i32 (i8*, ... )* @printf(i8* getelementptr inbounds ([4xi8]*@.println,i32 0, i32 0), i32 %u41)
